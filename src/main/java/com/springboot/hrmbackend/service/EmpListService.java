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

   public EmpList getEmpById(int id){
       return empListRepository.getById(id);
   }

   public void addEmp(EmpList emp){
     empListRepository.save(emp);
   }

   public void deleteEmpById(int id){
       empListRepository.deleteById(id);
   }

   public EmpList upDateEmp(EmpList emp){
       empListRepository.save(emp);
       return emp;
   }
}
