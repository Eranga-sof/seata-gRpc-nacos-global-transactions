package cn.wolfcode.tx.stock.grpc.server;


import cn.wolfcode.tx.stock.service.IStockService;
import com.devProblems.AllGrpcServiceGrpc;
import com.devProblems.RequestObject;
import com.devProblems.ResponseObject;
import com.devProblems.stockDeductRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class stockGrpcService extends AllGrpcServiceGrpc.AllGrpcServiceImplBase {

    @Autowired
    private IStockService stockService;

    @Override
    public void stockDeduct(stockDeductRequest request, StreamObserver<ResponseObject> responseObserver) {
        try {
            stockService.deduct(request.getCommodityCode(), request.getOrderCount());
            responseObserver.onNext(ResponseObject.newBuilder().setResult("SUCCESS").build());
            responseObserver.onCompleted();
        }catch (Exception exx){
            exx.printStackTrace();
            responseObserver.onNext(ResponseObject.newBuilder().setResult("FAIL").build());
            responseObserver.onCompleted();
        }

    }
}
