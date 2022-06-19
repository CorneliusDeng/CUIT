package it.mall.build.mapper;

import it.mall.build.entity.MallShoppingCartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallShoppingCartItemMapper {
    int deleteByPrimaryKey(Long cartItemId);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    MallShoppingCartItem selectByPrimaryKey(Long cartItemId);

    MallShoppingCartItem selectByUserIdAndGoodsId(@Param("MallUserId") Long mallUserId, @Param("goodsId") Long goodsId);

    List<MallShoppingCartItem> selectByUserId(@Param("MallUserId") Long mallUserId, @Param("number") int number);

    int selectCountByUserId(Long mallUserId);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

    int deleteBatch(List<Long> ids);
}