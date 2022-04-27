package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.exception.ResourceNotFoundException;
import com.springboot.hrmbackend.model.EmpList;
import com.springboot.hrmbackend.repository.EmpListRepository;
import com.springboot.hrmbackend.service.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmpListController {
  @Autowired
  private EmpListService empListService;

  //get all emp list
  @GetMapping("/emplist")
  public List<EmpList> getAllEmps(){
    return empListService.getAllList();
  }
  //post new emp
  @PostMapping("/emplist")
  public void addEmp(@RequestBody EmpList emp){
    empListService.addEmp(emp);
  }

  @PutMapping("/emplist/{id}")
  public ResponseEntity<EmpList> updateInfo(
    @PathVariable Integer id,
    @RequestBody EmpList empInfo)
  {
    EmpList emp = empListService.deleteEmpById()
      .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
    emp.setName(empInfo.getName());
    emp.setSex(empInfo.getSex());
    emp.setAge(empInfo.getAge());
    emp.setEmail(empInfo.getEmail());
    emp.setPhone(empInfo.getPhone());
    emp.setAddress(empInfo.getAddress());
    emp.setSalary(empInfo.getSalary());
    emp.setEntry_date(empInfo.getEntry_date());

    final EmpList updatedEmp = empListRepository.save(emp);
    return ResponseEntity.ok(updatedEmp);
  }

  //delete one emp by id
  @DeleteMapping("/emplist/{id}")
  public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id){
    empListService.deleteEmpById(id);
    return new ResponseEntity<>("emp is deleted", HttpStatus.OK);
  }
}
