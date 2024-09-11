package com.yifan.configuration;

import com.yifan.model.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * package_name: com.yifan.configuration
 * author: wyifa
 * date: 2024/9/11 20:16
 * description:
 */
@Configuration
public class BarConfiguration {

    /*****
     * why public：
     *  1. Reflection Access Restrictions
     *  2. Spring's Design Convention
     *  3. Code Readability and Maintainability：Marking @Bean methods as public makes the code's intention more explicit,
     *      indicating that the method is intended to expose a bean for the Spring container.
     * @return
     */
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
