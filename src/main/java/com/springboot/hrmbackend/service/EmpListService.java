package com.springboot.hrmbackend.service;

import com.springboot.hrmbackend.model.EmpList;
import com.springboot.hrmbackend.repository.EmpListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpListService {
   @Autowired
   private EmpListRepository empListRepository;

   public List<EmpList> getAllList(){
     return new ArrayList<>(empListRepository.findAll());
   }

   public Optional<EmpList> getEmpById(Integer id){
       return empListRepository.findById(id);
   }

   @Transactional
   public void addEmp(EmpList emp){
     empListRepository.save(emp);
   }

   @Transactional
   public void deleteEmp(Integer id){
       empListRepository.deleteById(id);
   }

/*    @Transactional
   public void upDateEmp(EmpList emp,int id){
       empListRepository.save(emp);
   }*/
}
