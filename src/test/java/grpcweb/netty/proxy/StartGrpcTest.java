package grpcweb.netty.proxy;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * This class starts the service on a port (property: grpc-port) and starts the
 * grpc-web proxy on a different port (property: grpc-web-port).
 */
class StartGrpcTest {
    private void startGrpcService(int port) throws Exception {
        Server grpcServer = ServerBuilder.forPort(port).addService((BindableService) new GreeterService())
                .addService((BindableService) new HelloImpl()).addService(new EchoImpl()).build();
        grpcServer.start();
        System.out.println("****  started gRPC Service on port # " + port);
    }

    public static void main(String[] args) throws Exception {
        new StartGrpcTest().startGrpcService(9090);

        System.in.read();
    }
}
