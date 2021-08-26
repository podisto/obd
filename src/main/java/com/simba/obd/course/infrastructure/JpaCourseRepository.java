package com.simba.obd.course.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by podisto on 26/08/2021.
 */
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
}
