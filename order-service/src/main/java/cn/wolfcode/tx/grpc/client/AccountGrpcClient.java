package cn.wolfcode.tx.grpc.client;

import com.devProblems.AllGrpcServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AccountGrpcClient {

    @GrpcClient("grpc-account-service")
    private AllGrpcServiceGrpc.AllGrpcServiceBlockingStub blockingStub;

    public String accountDeduct(String userId, int orderMoney) {
      try {
          return blockingStub.accountDeduct(com.devProblems.AccountRequest.newBuilder()
                  .setUserId(userId)
                  .setOrderMoney(orderMoney)
                  .build()).getResult();
      }
        catch (Exception e) {
            System.out.println("AccountGrpcClient.accountDeduct: " + e.getMessage());
            return "Fail";
        }
    }

}
