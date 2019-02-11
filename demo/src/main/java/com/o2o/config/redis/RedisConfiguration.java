package com.o2o.config.redis;

import com.o2o.cache.JedisPoolWriper;
import com.o2o.cache.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 对应spring-redis.xml中的配置
 */
@Configuration
public class RedisConfiguration {
	@Value("${redis.hostname}")
	private String hostname;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.pool.maxActive}")
	private int maxTotal;
	@Value("${redis.pool.maxIdle}")
	private int maxIdle;
	@Value("${redis.maxWait}")
	private long maxWaitMills;
	@Value("${redis.pool.testOnBorrow}")
	private boolean testOnBorrow;

	@Autowired
	private JedisPoolConfig jedisPoolConfig;
	@Autowired
	private JedisPoolWriper jedisPoolWriper;
	@Autowired
	private JedisUtil jedisUtil;

	//创建Jedis连接池的设置
	@Bean(name="jedisPoolConfig")
	public JedisPoolConfig createJedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new  JedisPoolConfig();
		//多少个Jedis实例
		jedisPoolConfig.setMaxTotal(maxTotal);
		//最多可空闲连接，不被清除，待命状态
		jedisPoolConfig.setMaxIdle(maxIdle);
		//最大等待时间
		jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
		//创建连接时检查有效性
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		return  jedisPoolConfig;
	}

	//创建Redis连接池
	@Bean(name = "jedisPoolWriper")
	public JedisPoolWriper createJedisPoolWriper(){
		JedisPoolWriper jedisPoolWriper = new JedisPoolWriper(
				jedisPoolConfig, hostname, port);

		return jedisPoolWriper;
	}

	//创建Redis工具类，默认是singleton(单例模式)的
	@Bean(name = "jedisUtil")
	public JedisUtil createJedisUtil(){
		JedisUtil jedisUtil = new JedisUtil();
		jedisUtil.setJedisPool(jedisPoolWriper);
		return jedisUtil;
	}

	//Redis的key操作，内部类实例创建
	@Bean(name = "jedisKeys")
	public JedisUtil.Keys createJedisKeys(){
		JedisUtil.Keys jedisKeys = jedisUtil.new Keys();
		return jedisKeys;
	}

	//Redis的Strings操作
	@Bean(name = "jedisStrings")
	public JedisUtil.Strings createJedisStrings(){
		JedisUtil.Strings jedisStrings = jedisUtil.new Strings();
		return jedisStrings;
	}

	//Redis的Lists操作
	@Bean(name = "jedisLists")
	public JedisUtil.Lists createJedisLists(){
		JedisUtil.Lists jedisLists = jedisUtil.new Lists();
		return jedisLists;
	}

	//Redis的Sets操作
	@Bean(name = "jedisSets")
	public JedisUtil.Sets createJedisSets(){
		JedisUtil.Sets jedisSets = jedisUtil.new Sets();
		return jedisSets;
	}

	//Redis的Hash操作
	@Bean(name = "jedisHash")
	public JedisUtil.Hash createJedisHash(){
		JedisUtil.Hash jedisHash = jedisUtil.new Hash();
		return jedisHash;
	}

}
