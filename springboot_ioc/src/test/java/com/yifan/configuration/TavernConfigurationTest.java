package com.yifan.configuration;

import com.yifan.model.Boss;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

/**
 * package_name: com.yifan.configuration
 * author: wyifa
 * date: 2024/9/11 19:54
 * description:
 */
class TavernConfigurationTest {

    @Test
    void testGetBossInConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Boss boss = (Boss) context.getBean(Boss.class);
        System.out.println(boss);

        assertNotNull(boss);
    }
}