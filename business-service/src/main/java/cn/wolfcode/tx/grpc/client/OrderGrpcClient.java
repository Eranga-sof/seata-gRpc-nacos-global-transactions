package cn.wolfcode.tx.grpc.client;


import com.devProblems.AllGrpcServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderGrpcClient {

    @GrpcClient("grpc-order-service")
    private AllGrpcServiceGrpc.AllGrpcServiceBlockingStub blockingStub;

    public String orderCreate(String userId, String commodityCode, int orderCount) {
       return blockingStub.orderCreate(com.devProblems.OrderRequest.newBuilder()
                .setUserId(userId)
                .setCommodityCode(commodityCode)
                .setOrderCount(orderCount)
                .build()).getResult();
    }
}
