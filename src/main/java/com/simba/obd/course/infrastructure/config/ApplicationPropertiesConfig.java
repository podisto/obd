package com.simba.obd.course.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by podisto on 26/08/2021.
 */
@ConfigurationProperties(prefix = "application")
@Data
public class ApplicationPropertiesConfig {

    private String uploadDirectory;
}
