package com.simba.obd;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by podisto on 26/08/2021.
 */
public interface StorageService {

    Media storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);

    String retrieve(String filename);
}
