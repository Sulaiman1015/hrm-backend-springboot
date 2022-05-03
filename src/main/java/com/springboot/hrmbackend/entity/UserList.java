package com.springboot.hrmbackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="userlist")
public class UserList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name="username",length = 20)
  private String username;

  @Column(name="password",length = 20)
  private String password;

  public UserList(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UserList() {

  }
}
