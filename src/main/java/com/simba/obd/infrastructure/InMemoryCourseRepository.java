package com.simba.obd.infrastructure;

import com.simba.obd.domain.Course;
import com.simba.obd.domain.CourseRepository;
import com.simba.obd.domain.Media;

import java.util.*;

/**
 * Created by podisto on 26/08/2021.
 */
public class InMemoryCourseRepository implements CourseRepository {

    private final Set<Media> medias = new HashSet<>();
    private final Set<Course> courses = new LinkedHashSet<>();

    @Override
    public void save(Course course) {
        for (Media media : course.getMedias()) {
            medias.add(media);
        }
        courses.add(course);
    }

    @Override
    public List<Course> all() {
        return new ArrayList<>(courses);
    }

    @Override
    public Optional<Course> findByTitle(String title) {
        return courses.stream()
                .filter(c -> c.getBookTitle().equals(title))
                .findFirst();
    }
}
