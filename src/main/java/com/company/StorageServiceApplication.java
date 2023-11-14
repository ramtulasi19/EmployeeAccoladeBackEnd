package com.company;

import com.company.entity.EmployeeDetail;
import com.company.entity.MyRequestDto;
import com.company.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/image")
@CrossOrigin("http://localhost:5173")
public class StorageServiceApplication {

	@Autowired
	private StorageService service;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("employeeName") String employeeName, @RequestParam("message")String message) throws IOException {


		EmployeeDetail employee = EmployeeDetail.builder()
				.employeeName(employeeName)
				.message(message)
				.imageData(file.getBytes()).build();
		service.uploadImage(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> allEmployees(){
		List<MyRequestDto> AllEmployees = service.allEmployeeDetails();
		return new ResponseEntity<>(AllEmployees, HttpStatus.OK);

	}

	public static void main(String[] args) {
		SpringApplication.run(StorageServiceApplication.class, args);
	}

}
