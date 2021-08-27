package com.simba.obd;

import java.util.List;
import java.util.Optional;

/**
 * Created by podisto on 26/08/2021.
 */
// The SPI interface
public interface CourseRepository {

    void save(Course course);

    List<Course> all();

    Optional<Course> findByTitle(String title);
}
