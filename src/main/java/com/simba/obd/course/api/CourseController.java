package com.simba.obd.course.api;

import com.simba.obd.course.domain.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by podisto on 26/08/2021.
 */
@Controller
@Slf4j
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String create(@ModelAttribute CourseFormDTO dto, @RequestParam("file") MultipartFile files) {
        courseService.add(dto, files);
        return "form_course";
    }
}
