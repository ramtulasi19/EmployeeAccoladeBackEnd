package com.company.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyRequestDto {
    private Long id;

    private String employeeName;

    private String message;

    private String imageData;
}