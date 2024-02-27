package com.devProblems;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: schema.proto")
public final class AllGrpcServiceGrpc {

  private AllGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "com.devProblems.AllGrpcService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.devProblems.stockDeductRequest,
      com.devProblems.ResponseObject> METHOD_STOCK_DEDUCT =
      io.grpc.MethodDescriptor.<com.devProblems.stockDeductRequest, com.devProblems.ResponseObject>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.devProblems.AllGrpcService", "stockDeduct"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.stockDeductRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.ResponseObject.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.devProblems.OrderRequest,
      com.devProblems.ResponseObject> METHOD_ORDER_CREATE =
      io.grpc.MethodDescriptor.<com.devProblems.OrderRequest, com.devProblems.ResponseObject>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.devProblems.AllGrpcService", "orderCreate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.OrderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.ResponseObject.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.devProblems.AccountRequest,
      com.devProblems.ResponseObject> METHOD_ACCOUNT_DEDUCT =
      io.grpc.MethodDescriptor.<com.devProblems.AccountRequest, com.devProblems.ResponseObject>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.devProblems.AllGrpcService", "accountDeduct"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.AccountRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.devProblems.ResponseObject.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AllGrpcServiceStub newStub(io.grpc.Channel channel) {
    return new AllGrpcServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AllGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AllGrpcServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AllGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AllGrpcServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AllGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void stockDeduct(com.devProblems.stockDeductRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STOCK_DEDUCT, responseObserver);
    }

    /**
     */
    public void orderCreate(com.devProblems.OrderRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ORDER_CREATE, responseObserver);
    }

    /**
     */
    public void accountDeduct(com.devProblems.AccountRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCOUNT_DEDUCT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_STOCK_DEDUCT,
            asyncUnaryCall(
              new MethodHandlers<
                com.devProblems.stockDeductRequest,
                com.devProblems.ResponseObject>(
                  this, METHODID_STOCK_DEDUCT)))
          .addMethod(
            METHOD_ORDER_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.devProblems.OrderRequest,
                com.devProblems.ResponseObject>(
                  this, METHODID_ORDER_CREATE)))
          .addMethod(
            METHOD_ACCOUNT_DEDUCT,
            asyncUnaryCall(
              new MethodHandlers<
                com.devProblems.AccountRequest,
                com.devProblems.ResponseObject>(
                  this, METHODID_ACCOUNT_DEDUCT)))
          .build();
    }
  }

  /**
   */
  public static final class AllGrpcServiceStub extends io.grpc.stub.AbstractStub<AllGrpcServiceStub> {
    private AllGrpcServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllGrpcServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllGrpcServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void stockDeduct(com.devProblems.stockDeductRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STOCK_DEDUCT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void orderCreate(com.devProblems.OrderRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ORDER_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accountDeduct(com.devProblems.AccountRequest request,
        io.grpc.stub.StreamObserver<com.devProblems.ResponseObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCOUNT_DEDUCT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AllGrpcServiceBlockingStub extends io.grpc.stub.AbstractStub<AllGrpcServiceBlockingStub> {
    private AllGrpcServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllGrpcServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllGrpcServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.devProblems.ResponseObject stockDeduct(com.devProblems.stockDeductRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STOCK_DEDUCT, getCallOptions(), request);
    }

    /**
     */
    public com.devProblems.ResponseObject orderCreate(com.devProblems.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ORDER_CREATE, getCallOptions(), request);
    }

    /**
     */
    public com.devProblems.ResponseObject accountDeduct(com.devProblems.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCOUNT_DEDUCT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AllGrpcServiceFutureStub extends io.grpc.stub.AbstractStub<AllGrpcServiceFutureStub> {
    private AllGrpcServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllGrpcServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllGrpcServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AllGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.devProblems.ResponseObject> stockDeduct(
        com.devProblems.stockDeductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STOCK_DEDUCT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.devProblems.ResponseObject> orderCreate(
        com.devProblems.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ORDER_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.devProblems.ResponseObject> accountDeduct(
        com.devProblems.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCOUNT_DEDUCT, getCallOptions()), request);
    }
  }

  private static final int METHODID_STOCK_DEDUCT = 0;
  private static final int METHODID_ORDER_CREATE = 1;
  private static final int METHODID_ACCOUNT_DEDUCT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AllGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AllGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STOCK_DEDUCT:
          serviceImpl.stockDeduct((com.devProblems.stockDeductRequest) request,
              (io.grpc.stub.StreamObserver<com.devProblems.ResponseObject>) responseObserver);
          break;
        case METHODID_ORDER_CREATE:
          serviceImpl.orderCreate((com.devProblems.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.devProblems.ResponseObject>) responseObserver);
          break;
        case METHODID_ACCOUNT_DEDUCT:
          serviceImpl.accountDeduct((com.devProblems.AccountRequest) request,
              (io.grpc.stub.StreamObserver<com.devProblems.ResponseObject>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AllGrpcServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.devProblems.Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AllGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AllGrpcServiceDescriptorSupplier())
              .addMethod(METHOD_STOCK_DEDUCT)
              .addMethod(METHOD_ORDER_CREATE)
              .addMethod(METHOD_ACCOUNT_DEDUCT)
              .build();
        }
      }
    }
    return result;
  }
}
