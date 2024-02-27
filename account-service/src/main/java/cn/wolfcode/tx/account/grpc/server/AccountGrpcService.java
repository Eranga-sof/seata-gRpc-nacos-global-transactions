package cn.wolfcode.tx.account.grpc.server;

import cn.wolfcode.tx.account.service.IAccountService;
import com.devProblems.AccountRequest;
import com.devProblems.AllGrpcServiceGrpc;
import com.devProblems.ResponseObject;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class AccountGrpcService extends AllGrpcServiceGrpc.AllGrpcServiceImplBase{

    @Autowired
    private IAccountService accountService;

    @Override
    public void accountDeduct(AccountRequest request, StreamObserver<ResponseObject> responseObserver) {
        try{
            //deduct account
            accountService.reduce(request.getUserId(), request.getOrderMoney());
            responseObserver.onNext(ResponseObject.newBuilder().setResult("SUCCESS").build());
            responseObserver.onCompleted();
        }catch (Exception e){
            responseObserver.onNext(ResponseObject.newBuilder().setResult("Fail").build());
            responseObserver.onError(e);
            responseObserver.onCompleted();
        }
    }
}
