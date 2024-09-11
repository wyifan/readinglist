package com.yifan.configuration;

import com.yifan.model.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * package_name: com.yifan.configuration
 * author: wyifa
 * date: 2024/9/11 19:50
 * description:
 */
@Configuration
public class BartenderConfiguration {

    @Bean
    public Bartender first(){
        return new Bartender("zhangxiaosan");
    }

    @Bean
    public Bartender second(){
        return new Bartender("wangxiaowu");
    }
}
