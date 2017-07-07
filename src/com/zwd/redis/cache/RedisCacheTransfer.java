/**
 * Copyright (c) 2017 qm
 * All right reserved.
 */
package com.zwd.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 类描述
 * @author 朱文德
 * @create_time 2017年7月6日 下午5:11:41
 * @project springRdis
 */
public class RedisCacheTransfer { 
  @Autowired
  public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
  RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
}}
