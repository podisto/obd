package com.simba.obd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by podisto on 26/08/2021.
 */
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByTitle(String title);
}
