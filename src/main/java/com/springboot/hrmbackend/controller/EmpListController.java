package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.exception.ResourceNotFoundException;
import com.springboot.hrmbackend.model.EmpList;
import com.springboot.hrmbackend.repository.EmpListRepository;
import com.springboot.hrmbackend.service.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class EmpListController {
  @Resource
  private EmpListService empListService;

  //get all emp list
  @GetMapping("/emplist")
  private List<EmpList> getAllEmps(){
    return empListService.getAllList();
  }

  //get emp by id
  @GetMapping("/emplist/{id}")
  private EmpList getEmpById(@PathVariable("id") Integer id){
    return empListService.getEmpById(id).get();
  }

  //post new emp
  @PostMapping("/emplist")
  private Integer addNewEmp(@RequestBody EmpList emp){
    empListService.addEmp(emp);
    return emp.getId();
  }

/*  @PutMapping("/emplist")
  private EmpList upDateInfo(@RequestBody EmpList emp) {
    return empListService.upDateEmp(emp);
    EmpList emp = empListService.deleteEmpById()
      .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
    emp.setName(empInfo.getName());
    emp.setSex(empInfo.getSex());
    emp.setAge(empInfo.getAge());
    emp.setEmail(empInfo.getEmail());
    emp.setPhone(empInfo.getPhone());
    emp.setAddress(empInfo.getAddress());
    emp.setEntry_date(empInfo.getEntry_date());

    final EmpList updatedEmp = empListService.
    return ResponseEntity.ok();
  }*/

  //delete one emp by id
  @DeleteMapping("/emplist")
  private String delete(Integer id){
    empListService.deleteEmp(id);
    return "delete success";
  }
}
