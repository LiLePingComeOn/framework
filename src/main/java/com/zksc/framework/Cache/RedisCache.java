package com.zksc.framework.Cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

public class RedisCache<k,v> implements Cache<k,v> {


    @Override
    public v get(k k) throws CacheException {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.opsForValue().get(k.toString());
        System.out.println("key is:" + k);
        return  (v) redisTemplate.opsForValue().get(k.toString());
    }

    @Override
    public v put(k k, v v) throws CacheException {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.opsForValue().set(k.toString(),v);
        System.out.println("key is:" + k);
        System.out.println("value is:" + v);
        return null;
    }

    @Override
    public v remove(k k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<k> keys() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }
}
