package com.company.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.EmployeeDetail;


public interface StorageRepository extends JpaRepository<EmployeeDetail,Long> {


}
