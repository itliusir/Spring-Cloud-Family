package com.demo.base.gateway.gatewayproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关Demo
 *
 * @author liugang
 * @since 2018-06-28
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayProxyApplication.class, args);
	}
}
