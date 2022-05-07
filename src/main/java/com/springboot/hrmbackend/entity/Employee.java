package com.springboot.hrmbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="emplist")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "id", unique = true, nullable = false)
  private Integer id;
  //@Column(name="name",length = 20)
  private String name;
  //@Column(name="sex",length = 6)
  private Character sex;
  //@Column(name="age",length = 6)
  private Integer age;
  //@Column(name="phone",length = 20)
  private String phone;
  //@Column(name="email",length = 32)
  private String email;
  //@Column(name="address",length = 50)
  private String address;
  //@Column(name="join_date",length = 20)
  private Date join_date;

}
