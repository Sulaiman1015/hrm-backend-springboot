package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.entity.Employee;
import com.springboot.hrmbackend.repository.EmpListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmpController {
  /*@Autowired
  private EmpListService empListService;

  //get all emp list
  @GetMapping("/emplist")
  private List<Employee> getAllEmps(){
    return empListService.getAllList();
  }

  //get emp by id
  @GetMapping("/emplist/{id}")
  private Employee getEmpById(@PathVariable("id") Integer id){
    return empListService.getEmpById(id).get();
  }

  //post new emp
  @PostMapping("/emplist")
  private String addNewEmp(@RequestBody Employee emp){
    empListService.addEmp(emp);
    return "save success";
  }

@PutMapping("/emplist/{id}")
  public ResponseEntity<Employee> updateInfo(
    @PathVariable("id") Integer id, @RequestBody Employee empInfo)
  {
    Employee emp = empListService.getEmpById(id)
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

  delete one emp by id ---Method 2 is ok too
  @DeleteMapping("/emplist")
  private String delete(Integer id){
    empListService.deleteEmp(id);
    return "delete success";
  }*/

    @Autowired
    private EmpListRepository empListRepository;

    //get all emp list
    @GetMapping("/emplist")
    public List<Employee> allEmps() {
        List<Employee> emplist = empListRepository.findAll();
        System.out.println(emplist);
        return emplist;
    }

    @PostMapping("/emp")
    public ResponseEntity<Employee> addEmp(@RequestBody @Valid Employee employee){

        Employee addEmp = empListRepository.save(employee);
        URI uriEmp = URI.create("/api/emp/"+addEmp.getId());
        return ResponseEntity.created(uriEmp).body(addEmp);
    }


}
