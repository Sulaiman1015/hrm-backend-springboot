package com.springboot.hrmbackend.service;

import com.springboot.hrmbackend.model.EmpList;
import com.springboot.hrmbackend.repository.EmpListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpListService {
   @Autowired
   private EmpListRepository empListRepository;

   public List<EmpList> getAllList(){
     return new ArrayList<>(empListRepository.findAll());
   }

   public void addEmp(EmpList emp){
     empListRepository.save(emp);
   }

   public void deleteEmpById(Integer id){
       empListRepository.deleteById(id);
   }
}
