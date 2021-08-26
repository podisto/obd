package com.simba.obd.course.domain;

import com.simba.obd.course.infrastructure.CourseEntity;

import java.time.LocalDate;

/**
 * Created by podisto on 26/08/2021.
 */
public class Session {
    private Long id;
    private LocalDate date;
    private Media media;
    private CourseEntity course;
}
