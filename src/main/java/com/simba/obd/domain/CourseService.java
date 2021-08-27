package com.simba.obd.domain;

import com.simba.obd.api.CourseFormDTO;
import com.simba.obd.api.CourseResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by podisto on 26/08/2021.
 */
// The API interface
public interface CourseService {

    void add(CourseFormDTO form, MultipartFile[] files);

    List<CourseResponseDTO> all();

    CourseResponseDTO find(String title);
}
