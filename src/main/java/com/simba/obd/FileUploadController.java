package com.simba.obd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by podisto on 27/08/2021.
 */
@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {

    private final StorageService storageService;

    @PostMapping("/upload")
    public @ResponseBody
    FileUploadResponse upload(@RequestParam("file") MultipartFile file) {
        Media media = storageService.storeFile(file);
        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(media.getFilename())
                .toUriString();

        return new FileUploadResponse(media, downloadUri);
    }

    @GetMapping("/download/{filename:.+}")
    public String retrieve(@PathVariable("filename") String filename) {
        return storageService.retrieve(filename);
    }


    /*@GetMapping("/download/{filename:.+}")
    public Resource retrieve(@PathVariable("filename") String filename, HttpServletRequest request, HttpServletResponse response) {
        Resource resource = storageService.loadFileAsResource(filename);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            log.info("could not determine file type");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        response.setContentType(String.valueOf(MediaType.parseMediaType(contentType)));
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
        return resource;

    }*/
}
