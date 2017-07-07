/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;

import com.zwd.redis.dao.UserDao;
import com.zwd.redis.models.User;

/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月7日 上午9:38:13
 * @project springRdis
 */
@Repository
public class UserDaoImpl implements UserDao {  
  
  @Autowired  
  private SqlSessionTemplate sqlSessionTemplate;  
    
  @Override  
  public User queryById(int id) {  
      return (User) sqlSessionTemplate.selectOne("queryById", id);  
  }  

  @Override  
  public void save(User u) {
      sqlSessionTemplate.insert("insert-user", u);  
  }  

  @Override  
  public void update(User u) {  
      sqlSessionTemplate.update("update-user", u);  
  }  

  @Override  
  public void delete(Integer id) {  
      sqlSessionTemplate.delete("delete-user",id);  
  }  

  @Override  
  public List<User> queryAll() {  
      List<User> users = sqlSessionTemplate.selectList("queryAll");  
      return users;  
  }  

}  