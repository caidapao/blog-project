package com.caidapao.today;

import com.caidapao.today.common.security.TodaySecurityParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({TodaySecurityParams.class})
public class TodayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodayApplication.class, args);
    }

}
