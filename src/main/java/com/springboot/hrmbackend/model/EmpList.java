package com.springboot.hrmbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="emplist")
public class EmpList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;
  @Column(name="name",length = 32)
  private String name;
  @Column(name="sex",length = 6)
  private Character sex;
  @Column(name="age",length = 6)
  private Integer age;
  @Column(name="phone",length = 20)
  private String phone;
  @Column(name="email",length = 32)
  private String email;
  @Column(name="address",length = 50)
  private String address;
  @Column(name="entry_date",length = 20)
  private String entry_date;

  /*public EmpList() {
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
  }*/

}
