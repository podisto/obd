package com.simba.obd.course.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class Course {
    private String bookTitle;
    private String location;
    private LocalDate date;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Media> medias;

    public Course() {
        this.medias = new ArrayList<>();
    }

    public void add(List<Media> medias) {
        this.medias.addAll(medias);
    }
}
