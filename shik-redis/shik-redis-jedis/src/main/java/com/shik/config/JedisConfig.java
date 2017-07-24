package com.shik.config;

import com.shik.support.util.JedisUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Shik on 2017/7/23.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class JedisConfig {

    @Bean(name = "jedisPool")
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(pool.min_idle);
        jedisPoolConfig.setMaxIdle(pool.max_idle);
        jedisPoolConfig.setMaxWaitMillis(pool.max_wait);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        JedisUtil.getInstance().setJedisPool(jedisPool);
        return jedisPool;
    }

    private String host;

    private int port;

    private int timeout;

    private String password;

    public static class Pool {

        private int min_idle;

        private int max_idle;

        private long max_wait;

        public int getMin_idle() {
            return min_idle;
        }

        public void setMin_idle(int min_idle) {
            this.min_idle = min_idle;
        }

        public int getMax_idle() {
            return max_idle;
        }

        public void setMax_idle(int max_idle) {
            this.max_idle = max_idle;
        }

        public long getMax_wait() {
            return max_wait;
        }

        public void setMax_wait(long max_wait) {
            this.max_wait = max_wait;
        }
    }

    private Pool pool;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }
}
