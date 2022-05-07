package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface EmpListRepository extends JpaRepository<Employee,Integer> {
}


