package com.vinod.config.client.controller;

import com.vinod.config.client.config.PaymentGatewayProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    /**
     * Note: To get updated property need to call actuator refresh endpoint.
     *
     * POST localhost:8080/actuator/refresh
     *
     * RabbitMQ : To get updated property for all the services simply call actuator bus refresh endpoint.
     *
     * POST localhost:8080/actuator/bus-refresh
     */
    @Value("${db.connectionUrl}")
    private String dbConnectionUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Autowired
    private PaymentGatewayProperty paymentGatewayProperty;

    @GetMapping("/")
    public String welcomePage() {
        return "Welcome to Spring Cloud Config Server";
    }

    @GetMapping("/db-config")
    public String dbConfiguration() {
        return "DB Property connection url: "+ dbConnectionUrl +" Username: "+dbUsername+" Password: "+dbPassword;
    }

    @GetMapping("/payment-gateway-config")
    public String paymentGatewayConfiguration() {
        return "Payment gateway connection : "+ paymentGatewayProperty;
    }
}
