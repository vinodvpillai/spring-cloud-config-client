package com.vinod.config.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("payment.gateway")
@Data
public class PaymentGatewayProperty {
    private String url;
    private String username;
    private String password;
}
