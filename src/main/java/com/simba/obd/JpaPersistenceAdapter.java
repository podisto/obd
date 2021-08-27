package com.simba.obd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Course> all() {
        return jpaCourseRepository.findAll()
                .stream()
                .map(this::toCourse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Course> findByTitle(String title) {
        Optional<CourseEntity> optional = jpaCourseRepository.findByTitle(title);
        if (optional.isPresent()) {
            Course course = toCourse(optional.get());
            return Optional.of(course);
        } else {
            return Optional.empty();
        }
    }

    private Course toCourse(CourseEntity entity) {
        Course course = new Course();
        course.setBookTitle(entity.getTitle());
        course.setLocation(entity.getLocation());
        course.setDate(entity.getDate());
        return course;
    }
}
