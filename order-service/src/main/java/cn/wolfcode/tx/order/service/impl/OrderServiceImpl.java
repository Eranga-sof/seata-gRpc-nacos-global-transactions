package cn.wolfcode.tx.order.service.impl;

import cn.wolfcode.tx.grpc.client.AccountGrpcClient;
import cn.wolfcode.tx.order.domain.Order;
import cn.wolfcode.tx.order.feign.AccountFeignClient;
import cn.wolfcode.tx.order.mapper.OrderMapper;
import cn.wolfcode.tx.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private AccountGrpcClient accountGrpcClient;

    @Override
    @Transactional
    public void create(String userId, String commodityCode, int count) {
        // 定单总价 = 订购数量(count) * 商品单价(100)
        int orderMoney = count * 100;
        // 生成订单
        Order order = new Order();
        order.setCount(count);
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        order.setMoney(orderMoney);
        super.save(order);

//        if (true) {
//            throw new RuntimeException("Failed to call Account Service. ");
//        }
        // 调用账户余额扣减 feign
//        String result = accountFeignClient.reduce(userId, orderMoney);
        // 调用账户余额扣减 grpc
        String result = accountGrpcClient.accountDeduct(userId, orderMoney);
        if (!"SUCCESS".equals(result)) {
            throw new RuntimeException("Failed to call Account Service. ");
        }

    }
}