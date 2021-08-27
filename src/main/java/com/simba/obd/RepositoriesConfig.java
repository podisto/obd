package com.simba.obd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by podisto on 27/08/2021.
 */
@Configuration
public class RepositoriesConfig {

    @Bean
    public CourseRepository courseRepository() {
        return new InMemoryCourseRepository();
    }
}
