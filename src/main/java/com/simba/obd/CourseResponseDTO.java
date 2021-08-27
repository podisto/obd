package com.simba.obd;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class CourseResponseDTO {
    private String title;
    private String location;
    private LocalDate date;
    private int sessionCount;

    public CourseResponseDTO(Course course) {
        this.title = course.getBookTitle();
        this.location = course.getLocation();
        this.date = course.getDate();
        this.sessionCount = course.getSessionCount();
    }
}
