package com.simba.obd;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by podisto on 26/08/2021.
 */
public interface StorageService {

    Media storeFile(MultipartFile file);
}
