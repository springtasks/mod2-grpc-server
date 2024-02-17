package org.example;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
            Hello.HelloRequest request, StreamObserver<Hello.HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        Hello.HelloResponse response = Hello.HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        System.out.println("Response Sent: "+ response.getGreeting());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
