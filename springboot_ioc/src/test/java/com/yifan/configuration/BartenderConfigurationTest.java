package com.yifan.configuration;

import com.yifan.model.Bartender;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * package_name: com.yifan.configuration
 * author: wyifa
 * date: 2024/9/11 20:01
 * description:
 */
class BartenderConfigurationTest {
    @Test
    void testTwoBartenderConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("-------------------------");
        Map<String, Bartender> bartenders = context.getBeansOfType(Bartender.class);
        bartenders.values().forEach(System.out::println);
        bartenders.forEach((name, bartender) -> {
            System.out.print(bartender.getName());
            System.out.print(" ");
            System.out.println(name);
        });

        assertEquals(2, bartenders.size());
    }

}