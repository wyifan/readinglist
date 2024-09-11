package com.yifan.model;

import com.yifan.configuration.TavernConfiguration;
import com.yifan.other.BarImportSelector;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * package_name: com.yifan.model
 * author: wyifa
 * date: 2024/9/11 20:55
 * description:
 */
class BarImportSelectorTest {

    @Test
    void testModelViaImportSelector() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        ModelViaSelectImport model = context.getBean(ModelViaSelectImport.class);
        System.out.println(model);
        // check bean exist
        System.out.println(context.containsBean(BarImportSelector.class.getName()));
        System.out.println(context.containsBean(ModelViaSelectImport.class.getName()));

        assertNotNull(model);
    }
}