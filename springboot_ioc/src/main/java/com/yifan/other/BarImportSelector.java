package com.yifan.other;

import com.yifan.configuration.BarConfiguration;
import com.yifan.model.Bar;
import com.yifan.model.ModelViaSelectImport;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * package_name: com.yifan
 * author: wyifa
 * date: 2024/9/11 20:22
 * description:
 * demonstrate that IOC container will get 2 Bar objects, but without BarImportSelector class itself.
 */
public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Bar.class.getName(), BarConfiguration.class.getName(), ModelViaSelectImport.class.getName()};
    }
}
