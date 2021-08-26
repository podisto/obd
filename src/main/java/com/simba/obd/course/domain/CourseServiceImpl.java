package com.simba.obd.course.domain;

import com.simba.obd.course.api.CourseFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

        Course course = new Course();
        course.setBookTitle(form.getTitle());
        course.setLocation(form.getLocation());
        course.setDate(form.getDate());
        course.add(medias);

        courseRepository.save(course);

    }
}
