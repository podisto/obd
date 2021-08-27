package com.simba.obd;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

/**
 * Created by podisto on 26/08/2021.
 */
@Service
public class FileSystemStorage implements StorageService {

    private final Path fileStorageLocation;

    public FileSystemStorage(ApplicationPropertiesConfig propertiesConfig) {
        this.fileStorageLocation = Paths.get(propertiesConfig.getUploadDirectory())
                .toAbsolutePath()
                .normalize();
        createUploadDirectory(this.fileStorageLocation);
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
        String fileName = StringUtils.cleanPath(originalFilename);
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry, filename contains invalid path sequence " +fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new FileStorageException("Could not store file " +fileName+ " Please try again ", e);
        }
        return new Media(fileName, file.getContentType(), file.getSize());
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " +fileName);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("File not found " + fileName, e);
        }
    }

    @Override
    public byte[] retrieve(String filename) {
        try {
            Path path = this.fileStorageLocation.resolve(filename).normalize();
            // File file = new File(path.toString());
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new FileNotFoundException("File not found " + filename, e);
        }
    }
}
