package com.simba.obd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by podisto on 26/08/2021.
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StorageService storageService;

    @Override
    public void add(CourseFormDTO form, MultipartFile[] files) {
        List<Media> medias = Arrays.stream(files)
                .map(storageService::storeFile)
                .collect(Collectors.toList());

        Course course = toCourse(form, medias);

        courseRepository.save(course);
    }

    private Course toCourse(CourseFormDTO form, List<Media> medias) {
        Course course = new Course();
        course.setBookTitle(form.getTitle());
        course.setLocation(form.getLocation());
        course.setDate(LocalDate.parse(form.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        course.add(medias);
        return course;
    }

    @Override
    public List<CourseResponseDTO> all() {
        return courseRepository.all()
                .stream()
                .map(CourseResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO find(String title) {
       return courseRepository.findByTitle(title)
               .map(CourseResponseDTO::new)
               .orElseThrow(() -> new EntityNotFoundException("Cours non trouvé"));
    }
}
