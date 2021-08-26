package com.simba.obd.course.domain;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class Course {
    private String bookTitle;
    private String location;
    private LocalDate date;
}
