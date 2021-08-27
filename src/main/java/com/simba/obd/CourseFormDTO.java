package com.simba.obd;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by podisto on 26/08/2021.
 */
@Data
public class CourseFormDTO {
    private String title;
    private String location;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //private String date;
}
