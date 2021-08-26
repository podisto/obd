package com.simba.obd.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by podisto on 26/08/2021.
 */
@Getter
@RequiredArgsConstructor
public class Media {
    private final String filename;
    private final String type;
    private final long size;
}
