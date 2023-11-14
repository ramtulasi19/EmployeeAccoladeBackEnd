package com.company.service;

import com.company.entity.EmployeeDetail;
import com.company.entity.MyRequestDto;
import com.company.respository.StorageRepository;
import com.company.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public void uploadImage(EmployeeDetail employeeDetail) throws IOException {

        EmployeeDetail employee = repository.save(EmployeeDetail.builder()
                .employeeName(employeeDetail.getEmployeeName())
                .imageData(ImageUtils.compressImage(employeeDetail.getImageData()))
                .message(employeeDetail.getMessage())
                .build());
    }

    public List<MyRequestDto> allEmployeeDetails() {

        List<EmployeeDetail> Employees = new ArrayList<>(repository.findAll());

       List<MyRequestDto> EmployeesDta = Employees.stream()
                .map(employeeDao ->  MyRequestDto.builder()
                        .employeeName(employeeDao.getEmployeeName())
                        .id(employeeDao.getId())
                        .message(employeeDao.getMessage())
                        .imageData(Base64Utils.encodeToString(ImageUtils.decompressImage(employeeDao.getImageData())))
                        .build())
                .collect(Collectors.toList());

        return EmployeesDta;
    }
}
