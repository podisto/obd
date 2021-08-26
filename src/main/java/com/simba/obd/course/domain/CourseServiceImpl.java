package com.simba.obd.course.domain;

import com.simba.obd.course.api.CourseFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by podisto on 26/08/2021.
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void add(CourseFormDTO form, MultipartFile files) {

    }
}
