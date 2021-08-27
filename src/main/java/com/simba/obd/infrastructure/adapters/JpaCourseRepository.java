package com.simba.obd.infrastructure.adapters;

import com.simba.obd.infrastructure.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by podisto on 26/08/2021.
 */
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByTitle(String title);
}
