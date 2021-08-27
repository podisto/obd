package com.simba.obd;

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
    private List<String> mediasUri;

    public CourseResponseDTO(Course course) {
        this.title = course.getBookTitle();
        this.location = course.getLocation();
        this.date = course.getDate();
    }

    public CourseResponseDTO(Course course, List<String> mediasUri) {
        this(course);
        this.mediasUri = mediasUri;
    }
}
