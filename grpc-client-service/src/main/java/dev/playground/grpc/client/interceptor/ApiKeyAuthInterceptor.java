package dev.playground.grpc.client.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;

/**
 * This interceptor is used to modify request metadata (add api key to authenticate the client)
 */
@GrpcGlobalClientInterceptor
@Slf4j
public class ApiKeyAuthInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions, Channel channel) {

        log.info("client interceptor {}", methodDescriptor.getFullMethodName());
        return new
                ForwardingClientCall.SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {
                    @Override
                    public void start(Listener<RespT> responseListener, Metadata headers) {
                        headers.put(Metadata.Key.of("x-api-key", Metadata.ASCII_STRING_MARSHALLER), "playground");
                        super.start(responseListener, headers);
                    }
                };
    }

}
