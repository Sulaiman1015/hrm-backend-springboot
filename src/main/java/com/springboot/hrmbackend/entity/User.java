package com.springboot.hrmbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="userlist")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "id", unique = true, nullable = false)
  private Integer id;

  //@Column(name="name",length = 20)
  private String rolename;

  //@Column(name="username",length = 20)
  private String username;

  //@Column(name="password",length = 20)
  private String password;

/*  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Role> roles = new HashSet<>();*/

}
