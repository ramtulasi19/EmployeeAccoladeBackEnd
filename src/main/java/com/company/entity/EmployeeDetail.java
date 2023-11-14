package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeDetail_3.0")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;

    private String message;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;
}
