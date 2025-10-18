package com.amk.pojo;

import lombok.Data;

@Data //lombok get set toString
public class User {
  private Integer id;
  private String username;
  private String password;
}