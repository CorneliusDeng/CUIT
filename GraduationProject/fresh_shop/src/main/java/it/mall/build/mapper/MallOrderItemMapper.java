package it.mall.build.mapper;

import it.mall.build.entity.MallOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallOrderItemMapper {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long orderItemId);

    // 根据订单id获取订单项列表
    List<MallOrderItem> selectByOrderId(Long orderId);

    // 根据订单ids获取订单项列表
    List<MallOrderItem> selectByOrderIds(@Param("orderIds") List<Long> orderIds);

    // 批量insert订单项数据
    int insertBatch(@Param("orderItems") List<MallOrderItem> orderItems);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);
}