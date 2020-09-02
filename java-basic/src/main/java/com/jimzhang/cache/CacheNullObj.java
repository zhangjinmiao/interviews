package com.jimzhang.cache;

import org.springframework.util.StringUtils;

public class CacheNullObj {

//    public String get(String key) {
//        // 从缓存中取数据
//        String cacheValue = cache.get(key);
//        // 缓存为空
//        if (StringUtils.isEmpty(cacheValue)) {
//            // 从存储中获取
//            String storageValue = storage.get(key);
//            cache.set(key, storageValue);
//            // 若果存储数据为空，设置过期时间
//            if (storageValue == null) {
//                cache.expire(key, 60 * 5);
//            }
//        }else {
//            // 缓存非空
//            return cacheValue;
//        }
//    }
}
