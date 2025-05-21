package dev.playground.feignclient;

import dev.playground.configuration.MyCustomLoadBalancerConfig;
import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

/**
 * Custom load balancer
 */
@LoadBalancerClient(value = "ADDRESS-SERVICE", configuration = MyCustomLoadBalancerConfig.class)
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
