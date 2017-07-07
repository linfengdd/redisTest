/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.dao;

import java.util.List;

import com.zwd.redis.models.User;

/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月7日 上午9:36:49
 * @project springRdis
 */
public interface UserDao  {  
  
  public User queryById(int id);  
    
  public void save(User u);  
    
  public void update(User u);  
    
  public void delete(Integer id);  
    
  public List<User> queryAll();  
}  
