package com.yifan.other;

import com.yifan.model.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * package_name: com.yifan.other
 * author: wyifa
 * date: 2024/9/11 21:06
 * description:
 */
public class WaiterRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("WaiterRegister implement ImportBeanDefinitionRegistrar invoked...");
        registry.registerBeanDefinition("waiterreg", new RootBeanDefinition(Waiter.class));
    }
}
