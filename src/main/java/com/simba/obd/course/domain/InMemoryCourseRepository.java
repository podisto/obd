package com.simba.obd.course.domain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by podisto on 26/08/2021.
 */
public class InMemoryCourseRepository implements CourseRepository {

    private final Set<Course> courses = new LinkedHashSet<>();

    @Override
    public void save(Course course) {
        courses.add(course);
    }
}
