/*
 * Copyright 2020  Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grpcweb.netty.proxy;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * TODO: Manage the connection pool to talk to the grpc-service
 */
class GrpcServiceConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    private final ManagedChannel channel;

    public GrpcServiceConnectionManager(int grpcPortNum) {
        // TODO: Manage a connection pool.
        channel = ManagedChannelBuilder.forAddress("localhost", grpcPortNum).usePlaintext().build();
        logger.info("**** connection channel initiated");
    }

    Channel getChannelWithClientInterceptor(GrpcWebClientInterceptor interceptor) {
        return ClientInterceptors.intercept(channel, interceptor);
    }
}
