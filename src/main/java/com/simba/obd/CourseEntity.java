package com.simba.obd;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by podisto on 26/08/2021.
 */
@Entity
@Table(name = "course")
@Data
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String location;
    private LocalDate date;
}
