package com.yifan.other;

import com.yifan.configuration.TavernConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * package_name: com.yifan.other
 * author: wyifa
 * date: 2024/9/11 21:10
 * description:
 */
class WaiterRegisterTest {
    @Test
    void testBeanViaImportBeanDefinitionRegistrar() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        assertTrue(context.containsBean("waiterreg"));
    }

}