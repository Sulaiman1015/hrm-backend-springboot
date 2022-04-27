package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.model.EmpList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpListRepository extends JpaRepository<EmpList,Integer> {

}


