package it.mall.build.service;

import it.mall.build.controller.vo.MallOrderDetailVO;
import it.mall.build.controller.vo.MallOrderItemVO;
import it.mall.build.controller.vo.MallShoppingCartItemVO;
import it.mall.build.controller.vo.MallUserVO;
import it.mall.build.entity.MallOrder;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;

import java.util.List;

public interface MallOrderService {
    // 后台分页
    PageResult getMallOrdersPage(PageQueryUtil pageUtil);

    // 订单信息修改
    String updateOrderInfo(MallOrder mallOrder);

    // 配货
    String checkDone(Long[] ids);

    // 出库
    String checkOut(Long[] ids);

    // 关闭订单
    String closeOrder(Long[] ids);

    // 保存订单
    String saveOrder(MallUserVO user, List<MallShoppingCartItemVO> myShoppingCartItems);

    // 获取订单详情
    MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    // 获取订单详情
    MallOrder getMallOrderByOrderNo(String orderNo);

    // 我的订单列表
    PageResult getMyOrders(PageQueryUtil pageUtil);

    // 手动取消订单
    String cancelOrder(String orderNo, Long userId);

    // 确认收货
    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    List<MallOrderItemVO> getOrderItems(Long id);
}
