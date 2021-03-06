/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.zwd.redis.dao.UserDao;
import com.zwd.redis.models.User;

/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月7日 下午3:10:25
 * @project springRedis
 */
@Service
public class UserService {
  
  @Autowired(required = false) 
  TransactionTemplate txTemplate;
  
  @Autowired
  UserDao userDao;
  
  public Boolean SaveUserList(final List<User> list){
      
    Boolean retVal =txTemplate.execute(new TransactionCallback<Boolean>(){

        @Override
        public Boolean doInTransaction(TransactionStatus status) { 
          boolean result=true;
          try {
            for (User user : list) {
              userDao.save(user);
            }
        } catch (Exception e) {
            status.setRollbackOnly();
            result = false;
            System.out.println("Transfer Error!");
        }
        return result;
        }    
      });
    return retVal;
  }
}
