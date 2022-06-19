package it.mall.build.service;

import it.mall.build.controller.vo.MallShoppingCartItemVO;
import it.mall.build.entity.MallShoppingCartItem;

import java.util.List;

public interface MallShoppingCartService {

    // 保存商品至购物车中
    String saveMallCartItem(MallShoppingCartItem mallShoppingCartItem);

    // 修改购物车中的属性
    String updateMallCartItem(MallShoppingCartItem mallShoppingCartItem);

    // 获取购物项详情
    MallShoppingCartItem getMallCartItemById(Long mallShoppingCartItemId);

    // 删除购物车中的商品
    Boolean deleteById(Long mallShoppingCartItemId);

    // 获取我的购物车中的列表数据
    List<MallShoppingCartItemVO> getMyShoppingCartItems(Long mallUserId);
}
