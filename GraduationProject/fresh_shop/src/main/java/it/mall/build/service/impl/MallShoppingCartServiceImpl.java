package it.mall.build.service.impl;

import it.mall.build.common.Constants;
import it.mall.build.common.ServiceResultEnum;
import it.mall.build.controller.vo.MallShoppingCartItemVO;
import it.mall.build.mapper.MallGoodsMapper;
import it.mall.build.mapper.MallShoppingCartItemMapper;
import it.mall.build.entity.MallGoods;
import it.mall.build.entity.MallShoppingCartItem;
import it.mall.build.service.MallShoppingCartService;
import it.mall.build.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MallShoppingCartServiceImpl implements MallShoppingCartService {

    @Autowired
    private MallShoppingCartItemMapper mallShoppingCartItemMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    // 修改session中购物项数量
    @Override
    public String saveMallCartItem(MallShoppingCartItem mallShoppingCartItem) {
        MallShoppingCartItem temp = mallShoppingCartItemMapper.selectByUserIdAndGoodsId(mallShoppingCartItem.getUserId(), mallShoppingCartItem.getGoodsId());
        if (temp != null) {
            //已存在则修改该记录
            //todo count = tempCount + 1
            temp.setGoodsCount(mallShoppingCartItem.getGoodsCount());
            return updateMallCartItem(temp);
        }
        MallGoods mallGoods = mallGoodsMapper.selectByPrimaryKey(mallShoppingCartItem.getGoodsId());
        // 商品为空
        if (mallGoods == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        int totalItem = mallShoppingCartItemMapper.selectCountByUserId(mallShoppingCartItem.getUserId());
        // 超出最大数量
        if (totalItem > Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR.getResult();
        }
        // 保存记录
        if (mallShoppingCartItemMapper.insertSelective(mallShoppingCartItem) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateMallCartItem(MallShoppingCartItem mallShoppingCartItem) {
        MallShoppingCartItem mallShoppingCartItemUpdate = mallShoppingCartItemMapper.selectByPrimaryKey(mallShoppingCartItem.getCartItemId());
        if (mallShoppingCartItemUpdate == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        // 超出最大数量
        if (mallShoppingCartItem.getGoodsCount() > Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR.getResult();
        }
        // 数量相同不会进行修改，userId不同不能修改
        mallShoppingCartItemUpdate.setGoodsCount(mallShoppingCartItem.getGoodsCount());
        mallShoppingCartItemUpdate.setUpdateTime(new Date());
        // 保存记录
        if (mallShoppingCartItemMapper.updateByPrimaryKeySelective(mallShoppingCartItemUpdate) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallShoppingCartItem getMallCartItemById(Long mallShoppingCartItemId) {
        return mallShoppingCartItemMapper.selectByPrimaryKey(mallShoppingCartItemId);
    }

    @Override
    public Boolean deleteById(Long mallShoppingCartItemId) {
        // userId不同不能删除
        return mallShoppingCartItemMapper.deleteByPrimaryKey(mallShoppingCartItemId) > 0;
    }

    // 获取当前执行操作用户的购物车商品信息
    @Override
    public List<MallShoppingCartItemVO> getMyShoppingCartItems(Long mallUserId) {
        List<MallShoppingCartItemVO> mallShoppingCartItemVOS = new ArrayList<>();
        List<MallShoppingCartItem> mallShoppingCartItems = mallShoppingCartItemMapper.selectByUserId(mallUserId, Constants.SHOPPING_CART_ITEM_TOTAL_NUMBER);
        if (!CollectionUtils.isEmpty(mallShoppingCartItems)) {
            // 查询商品信息并做数据转换
            List<Long> mallGoodsIds = mallShoppingCartItems.stream().map(MallShoppingCartItem::getGoodsId).collect(Collectors.toList());
            List<MallGoods> mallGoods = mallGoodsMapper.selectByPrimaryKeys(mallGoodsIds);
            Map<Long, MallGoods> mallGoodsMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(mallGoods)) {
                mallGoodsMap = mallGoods.stream().collect(Collectors.toMap(MallGoods::getGoodsId, Function.identity(), (entity1, entity2) -> entity1));
            }
            for (MallShoppingCartItem mallShoppingCartItem : mallShoppingCartItems) {
                MallShoppingCartItemVO mallShoppingCartItemVO = new MallShoppingCartItemVO();
                BeanUtil.copyProperties(mallShoppingCartItem, mallShoppingCartItemVO);
                if (mallGoodsMap.containsKey(mallShoppingCartItem.getGoodsId())) {
                    MallGoods mallGoodsTemp = mallGoodsMap.get(mallShoppingCartItem.getGoodsId());
                    mallShoppingCartItemVO.setGoodsCoverImg(mallGoodsTemp.getGoodsCoverImg());
                    String goodsName = mallGoodsTemp.getGoodsName();
                    // 字符串过长导致文字超出的问题
                    if (goodsName.length() > 28) {
                        goodsName = goodsName.substring(0, 28) + "...";
                    }
                    mallShoppingCartItemVO.setGoodsName(goodsName);
                    mallShoppingCartItemVO.setSellingPrice(mallGoodsTemp.getSellingPrice());
                    mallShoppingCartItemVOS.add(mallShoppingCartItemVO);
                }
            }
        }
        return mallShoppingCartItemVOS;
    }
}
