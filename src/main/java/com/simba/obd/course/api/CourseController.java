package com.simba.obd.course.api;

import com.simba.obd.course.domain.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/nouveau")
    public String displayForm(Model model) {
        model.addAttribute("courseForm", new CourseFormDTO());
        return "courses/form";
    }

    @PostMapping
    public String create(@ModelAttribute CourseFormDTO dto, @RequestParam("files") MultipartFile[] files) {
        courseService.add(dto, files);
        return null;
    }
}
