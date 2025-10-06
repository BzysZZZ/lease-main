package com.qianlou.app.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;

import org.glassfish.jaxb.core.v2.TODO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis缓存工具类
 * 用于提供与Redis缓存相关的操作功能
 */
@Component  // 将此类标记为Spring组件，自动注册到Spring容器中
public class RedisCacheUtil{

    @Resource
    public RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    /**
    * 设置缓存
    * @param key 缓存的键
    * @param value 缓存的值
    * @param timeout 过期时间
    * @param unit 时间单位（如TimeUnit.SECONDS、TimeUnit.MINUTES等）
    */
    public void setCache(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public <T> T getCache(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        try{
            if (value == null) {
                return null;
            }
            // 如果是字符串类型，直接解析
            if (value instanceof String) {
                return objectMapper.readValue((String) value, clazz);
            }
            // 如果是其他类型，先转为JSON字符串再解析
            String jsonString = objectMapper.writeValueAsString(value);
            return objectMapper.readValue(jsonString, clazz);
        }catch(JsonProcessingException e){
            throw new RuntimeException("Json解析错误", e);
        }
    }

    /**
     * 获取泛型集合缓存
     * @param key 缓存键
     * @param collectionClass 集合类型
     * @param elementClasses 元素类型
     * @param <T> 返回类型
     * @return 缓存的对象
     */
    // TODO:该方法实现从Redis缓存中获取泛型集合类型的对象，方法有问题待修复，无法从redis中获取到正确的集合类型
    public <T> T getCacheList(String key, Class<?> collectionClass, Class<?>... elementClasses) {
        Object value = redisTemplate.opsForValue().get(key);
        try {
            if (value == null) {
                return null;
            }
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
            if (value instanceof String) {
                return objectMapper.readValue((String) value, javaType);
            }
            String jsonString = objectMapper.writeValueAsString(value);
            return objectMapper.readValue(jsonString, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json解析错误", e);
        }
    }

    public boolean deleteCache(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }
}