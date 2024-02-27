package cn.wolfcode.tx.grpc.client;


import com.devProblems.AllGrpcServiceGrpc;
import io.grpc.Metadata;
import io.seata.core.context.RootContext;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockGrpcClient {

    @GrpcClient("grpc-stock-service")
    private AllGrpcServiceGrpc.AllGrpcServiceBlockingStub blockingStub;

    public String stockDeduct(String commodityCode, int orderCount) {
       return blockingStub.stockDeduct(com.devProblems.stockDeductRequest.newBuilder()
                .setCommodityCode(commodityCode)
                .setOrderCount(orderCount)
                .build()).getResult();
    }
}
