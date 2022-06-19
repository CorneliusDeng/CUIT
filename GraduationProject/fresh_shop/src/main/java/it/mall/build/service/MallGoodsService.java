package it.mall.build.service;

import it.mall.build.entity.MallGoods;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;

import java.util.List;

public interface MallGoodsService {
	
    // 后台分页
    PageResult getMallGoodsPage(PageQueryUtil pageUtil);

    // 添加商品添加商品
    String saveMallGoods(MallGoods goods);

    // 批量新增商品数据
    void batchSaveMallGoods(List<MallGoods> mallGoodsList);

    // 修改商品信息
    String updateMallGoods(MallGoods goods);

    // 获取商品详情
    MallGoods getMallGoodsById(Long id);

    // 批量修改销售状态(上架下架)
    Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);

    // 商品搜索
    PageResult searchMallGoods(PageQueryUtil pageUtil);

    // 删除商品
	int deleteGoodById(Long goodsId);
}
