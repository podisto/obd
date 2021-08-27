package com.simba.obd.api;

import com.simba.obd.domain.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by podisto on 26/08/2021.
 */
@Controller
@Slf4j
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String list(Model model) {
        List<CourseResponseDTO> courses = courseService.all();
        courses.forEach(c -> log.info("Course {}", c));
        model.addAttribute("courses", courses);
        return "courses/list";
    }

    @GetMapping("/{title}")
    public String displaySessions(@PathVariable("title") String title, Model model) {
        log.info("display audio for course {}", title);
        CourseResponseDTO course = courseService.find(title);
        log.info("cours {}", course);
        model.addAttribute("course", course);
        return "courses/sessions";
    }

    @GetMapping("/nouveau")
    public String displayForm(Model model) {
        model.addAttribute("courseForm", new CourseFormDTO());
        return "courses/form";
    }

    @PostMapping
    public String create(@ModelAttribute CourseFormDTO dto, @RequestParam("files") MultipartFile[] files) {
        log.info("Courses {}", dto);
        courseService.add(dto, files);
        return "redirect:/courses";
    }
}
