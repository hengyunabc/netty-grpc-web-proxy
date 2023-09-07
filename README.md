

## netty grpc web proxy

from: https://github.com/grpc/grpc-web/tree/1.4.2/src/connector

原项目已废弃删除，本项目改用 netty 来做转发。

## 缺点

原项目需要 `.proto` 文件编译的 `.class`才能运行，比如`GreeterGrpc`，本项目同样有这个问题。


## 测试

工程导入IDE之后

1. 启动 grpcweb.netty.proxy.StartGrpcTest
2. 启动 grpcweb.netty.proxy.GrpcWebProxyTestServer
3. cd browser-test ，启动 http server，比如 `python -m http.server`
4. 访问上面启动的 http server，比如 http://127.0.0.1:8000/echotest.html


也可以用原项目的相关工程来测试

* https://github.com/grpc/grpc-web/


## 开发验证

可以用其它的 grpc web proxy来抓包辅助验证。

### 用 envoy

下载envoy 后，可以用本项目里的`envoy.yaml`

* `envoy --config-path ./envoy.yaml`

### 使用 grpcwebproxy 

* https://github.com/improbable-eng/grpc-web/blob/master/go/grpcwebproxy/README.md

下载后，启动：

* `grpcwebproxy --backend_addr 127.0.0.1:9090 --run_tls_server=false --allow_all_origins`


## TODO

增加测试

