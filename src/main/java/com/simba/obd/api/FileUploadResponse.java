package com.simba.obd.api;

import com.simba.obd.domain.Media;
import lombok.Getter;

/**
 * Created by podisto on 27/08/2021.
 */
@Getter
public class FileUploadResponse {
    private String fileName;
    private String downloadUri;
    private String contentType;
    private long size;

    public FileUploadResponse(Media media, String downloadUri) {
        this.fileName = media.getFilename();
        this.downloadUri = downloadUri;
        this.contentType = media.getContentType();
        this.size = media.getSize();
    }
}
