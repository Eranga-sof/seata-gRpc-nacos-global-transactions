package cn.wolfcode.tx.grpc.server;

import cn.wolfcode.tx.order.service.IOrderService;
import com.devProblems.AllGrpcServiceGrpc;
import com.devProblems.OrderRequest;
import com.devProblems.ResponseObject;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class OrderGrpcService extends AllGrpcServiceGrpc.AllGrpcServiceImplBase {

    @Autowired
    private IOrderService orderService;

    @Override
    public void orderCreate(OrderRequest request, StreamObserver<ResponseObject> responseObserver) {
        try {
            orderService.create(request.getUserId(), request.getCommodityCode(), request.getOrderCount());
            responseObserver.onNext(ResponseObject.newBuilder().setResult("SUCCESS").build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
            responseObserver.onCompleted();

        }

    }
}
