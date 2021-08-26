package com.simba.obd.course.infrastructure;

import com.simba.obd.course.domain.Course;
import com.simba.obd.course.domain.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by podisto on 26/08/2021.
 */
@Service
@RequiredArgsConstructor
public class JpaPersistenceAdapter implements CourseRepository {

    private final JpaCourseRepository jpaCourseRepository;

    @Override
    public void save(Course course) {
        CourseEntity entity = new CourseEntity();
        entity.setLocation(course.getLocation());
        entity.setTitle(course.getBookTitle());
        jpaCourseRepository.save(entity);
    }
}
