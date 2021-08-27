package com.simba.obd;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by podisto on 26/08/2021.
 */
@Getter
@RequiredArgsConstructor
@ToString
public class Media {
    private final String filename;
    private final String contentType;
    private final long size;
}
