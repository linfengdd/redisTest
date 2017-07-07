/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwd.redis.dao.UserDao;
import com.zwd.redis.models.User;
import com.zwd.redis.service.UserService;


/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月3日 下午4:19:22
 * @project springRdis
 */
@Controller
@RequestMapping("/route") 
public class WebHost {
  
  Logger loger=LoggerFactory.getLogger(getClass());
  @Autowired
  UserDao userDao;
  
  @Autowired
  UserService userService;
  
  @RequestMapping(value="/user", method={RequestMethod.GET,RequestMethod.POST},produces="application/json; charset=utf-8") 
  @ResponseBody
  public String handleRequest(HttpServletRequest request)
  {
    String uid= request.getParameter("uid");
    if(uid==null){
      List<User>list= userDao.queryAll();
      JSONArray array=new JSONArray(list);
      return array.toString();
    }
    User user=userDao.queryById(Integer.parseInt(uid));
    JSONObject object=new JSONObject(user);
    return object.toString();
  }
  
  
  @RequestMapping(value="/saveUser", method={RequestMethod.GET,RequestMethod.POST},produces="application/json; charset=utf-8") 
  @ResponseBody
  public String handleRequestSave(HttpServletRequest request)
  {
      String message="";
      String count=request.getParameter("count");
      if(null==count){
        message="参数count为空，不能插入";
        loger.debug("参数count为空，不能插入");
        return message;
      }
      int c= Integer.parseInt(count);
      List<User> list=new ArrayList<>();
      for(int i=0;i<c;i++){
        list.add(new User("z"+i,i+""));
      }
      userService.SaveUserList(list);
      message="保存成功了";
      return message;
  }
  
}
