/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.models;

import java.io.Serializable;

/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月7日 上午9:35:49
 * @project springRdis
 */
public class User implements Serializable {  
  
  /** 
   *  
   */  
  private static final long serialVersionUID = 1L;  

  private int uid;  
  private String userName;  
  private String password;  

  public User(String userName,String password){
    this.userName=userName;
    this.password=password;   
  }
  
  public User(int uid,String userName,String password){
    this.uid=uid;
    this.userName=userName;
    this.password=password;   
  }
  public int getUid() {  
      return uid;  
  }  

  public void setUid(int uid) {  
      this.uid = uid;  
  }  

  public String getUserName() {  
      return userName;  
  }  

  public void setUserName(String userName) {  
      this.userName = userName;  
  }  

  public String getPassword() {  
      return password;  
  }  

  public void setPassword(String password) {  
      this.password = password;  
  }  

  public static long getSerialversionuid() {  
      return serialVersionUID;  
  }  

  @Override  
  public String toString() {  
      return "uId: "+this.uid + ", Name: " + this.userName + ",Pass: " + this.password;  
  }  
}