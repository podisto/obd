package com.simba.obd;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by podisto on 26/08/2021.
 */
@Configuration
public class ThymeleafLayoutDialectConfig {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
