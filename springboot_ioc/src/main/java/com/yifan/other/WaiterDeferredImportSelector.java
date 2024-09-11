package com.yifan.other;

import com.yifan.model.Waiter;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * package_name: com.yifan.other
 * author: wyifa
 * date: 2024/9/11 21:43
 * description:
 */
public class WaiterDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("Invoke in WaiterDeferredImportSelector selectImports methods....");
        return new String[]{Waiter.class.getName()};
    }
}
