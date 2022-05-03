package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.exception.ResourceNotFoundException;
import com.springboot.hrmbackend.entity.EmpList;
import com.springboot.hrmbackend.service.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class EmpController {
  @Autowired
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
  private String addNewEmp(@RequestBody EmpList emp){
    empListService.addEmp(emp);
    return "save success";
  }

@PutMapping("/emplist/{id}")
  public ResponseEntity<EmpList> updateInfo(
    @PathVariable("id") Integer id, @RequestBody EmpList empInfo)
  {
    EmpList emp = empListService.getEmpById(id)
      .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
    //emp.setId(empInfo.getId());
    emp.setName(empInfo.getName());
    emp.setSex(empInfo.getSex());
    emp.setAge(empInfo.getAge());
    emp.setEmail(empInfo.getEmail());
    emp.setPhone(empInfo.getPhone());
    emp.setAddress(empInfo.getAddress());
    emp.setJoin_date(empInfo.getJoin_date());

    //final EmpList updatedEmp = empListService.upDateEmp(emp);
    //return ResponseEntity.ok(updatedEmp);
    return ResponseEntity.ok(empListService.upDateEmp(emp));
  }

  //delete one emp by id ---Method 1 is ok
  @DeleteMapping("/emplist/{id}")
  public String deleteEmp(@PathVariable("id") Integer id){
    empListService.deleteEmp(id);
    return "delete success";
  }

  /*//delete one emp by id ---Method 2 is ok too
  @DeleteMapping("/emplist")
  private String delete(Integer id){
    empListService.deleteEmp(id);
    return "delete success";
  }*/
}
