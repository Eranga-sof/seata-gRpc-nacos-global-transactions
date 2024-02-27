package cn.wolfcode.tx.business.service.impl;


import cn.wolfcode.tx.business.feign.OrderFeignClient;
import cn.wolfcode.tx.business.feign.StockFeignClient;
import cn.wolfcode.tx.business.service.IBusinessService;
import cn.wolfcode.tx.grpc.client.OrderGrpcClient;
import cn.wolfcode.tx.grpc.client.StockGrpcClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements IBusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    private StockFeignClient stockFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private StockGrpcClient stockClientService;

    @Autowired
    private OrderGrpcClient orderGrpcClient;


    @Override
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount, boolean rollback) {
        // fign client
//        String result = stockFeignClient.deduct(commodityCode, orderCount);
        //grpc client
        String result = stockClientService.stockDeduct(commodityCode, orderCount);

        if (!"SUCCESS".equals(result)) {
            throw new RuntimeException("库存服务调用失败,事务回滚!");
        }

        // fign client
//        result = orderFeignClient.create(userId, commodityCode, orderCount);
        // grpc client
        result = orderGrpcClient.orderCreate(userId, commodityCode, orderCount);

        if (!"SUCCESS".equals(result)) {
            throw new RuntimeException("订单服务调用失败,事务回滚!");
        }

        if (rollback) {
            throw new RuntimeException("Force rollback ... ");
        }
    }
}
