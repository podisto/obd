package com.simba.obd.domain;

import com.simba.obd.config.ApplicationPropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by podisto on 26/08/2021.
 */
@Service
@Slf4j
public class FileSystemStorage implements StorageService {

    private final String uploadLocation;

    public FileSystemStorage(ApplicationPropertiesConfig propertiesConfig) {
        this.uploadLocation = propertiesConfig.getUploadDirectory();
        log.info("Upload location {}", this.uploadLocation);

        createUploadDirectory(Paths.get(this.uploadLocation));
    }

    private void createUploadDirectory(Path fileStorageLocation) {
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception e) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored ", e);
        }
    }

    @Override
    public Media storeFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            throw new FileStorageException("Cannot upload empty files");
        }

        String filename = generateUniqueName(originalFilename);

        try (OutputStream os = new FileOutputStream(this.uploadLocation + filename)) {
            os.write(file.getBytes());
            return new Media(filename, file.getContentType(), file.getSize());
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " +originalFilename+ " Please try again ", e);
        }
    }

    private String generateUniqueName(String originalFilename) {
        String timestamp = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        String filename = originalFilename.replace(" ","_");
        filename = timestamp + filename;
        return filename;
    }

}
