package com.simba.obd.course.domain;

import com.simba.obd.course.api.CourseFormDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by podisto on 26/08/2021.
 */
// The API interface
public interface CourseService {

    void add(CourseFormDTO form, MultipartFile[] files);
}
