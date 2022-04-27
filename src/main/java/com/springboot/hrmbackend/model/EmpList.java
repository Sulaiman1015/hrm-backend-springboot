package com.springboot.hrmbackend.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="emplist")
public class EmpList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //@Column(name="name")
  private String name;
  //@Column(name="sex")
  private Character sex;
  //@Column(name="age")
  private Integer age;
  //@Column(name="phone")
  private String phone;
  //@Column(name="email")
  private String email;
  //@Column(name="address")
  private String address;
  //@Column(name="entry_date")
  private String entry_date;

  public EmpList() {
  }

  public EmpList(String name, char sex, int age,
                 String phone, String email, String address,
                 String entry_date)
  {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.entry_date = entry_date;
  }

  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Character getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEntry_date() {
    return entry_date;
  }

  public void setEntry_date(String entry_date) {
    this.entry_date = entry_date;
  }

}
