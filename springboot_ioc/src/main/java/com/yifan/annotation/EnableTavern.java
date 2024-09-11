package com.yifan.annotation;

import com.yifan.configuration.BartenderConfiguration;
import com.yifan.model.Bartender;
import com.yifan.model.Boss;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * package_name: com.yifan.self
 * author: wyifa
 * date: 2024/9/11 19:44
 * description:
 *      using import annotation to import class
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class})
public @interface EnableTavern {
}
