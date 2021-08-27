package com.simba.obd.api;

import com.simba.obd.domain.Course;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class CourseResponseDTO {
    private String title;
    private String location;
    private LocalDate date;
    private List<String> medias;

    public CourseResponseDTO(Course course) {
        this.title = course.getBookTitle();
        this.location = course.getLocation();
        this.date = course.getDate();
    }

    public CourseResponseDTO(Course course, List<String> medias) {
        this(course);
        this.medias = medias;
    }
}
