package com.simba.obd.course.api;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class CourseFormDTO {
    private String title;
    private String location;
    private LocalDate date;
}
