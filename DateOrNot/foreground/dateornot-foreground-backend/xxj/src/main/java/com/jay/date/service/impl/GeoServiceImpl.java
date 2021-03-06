package com.jay.date.service.impl;

import com.jay.date.service.GeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jay
 */
@Service
public class GeoServiceImpl implements GeoService {
    private final RedisTemplate<String, String> redisTemplate;
    private final String ADDRESS_KEY_PREFIX = "user_addr:";
    /**
     * 缓存key
     */
    private static final String CACHE_KEY = "GEO_TEST";
    private final Logger logger;
    @Autowired
    public GeoServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    @Override
    public Boolean saveUserLocation(String member, Double latitude, Double longitude) {
        if(member == null  || member.isEmpty() || invalidCoordinates(latitude, longitude)){
            return false;
        }
        // 封装坐标
        Point point = new Point(longitude, latitude);
        Long s1 = redisTemplate.opsForZSet().remove(CACHE_KEY, member);
        logger.info("清除用户：id=" + member + "过期位置信息, 状态：" + s1);
        Long status = 0L;
        // geoAdd操作
        if(s1 != null){
            status = redisTemplate.opsForGeo().add(CACHE_KEY, point, member);
        }
        return status != null && status > 0;
    }

    @Override
    public Boolean saveUserAddress(String member, String address) {
        if(member == null || member.isEmpty() || address == null || address.isEmpty()){
            throw new IllegalArgumentException("记录用户地址参数错误");
        }
        try{
            redisTemplate.opsForValue().set(ADDRESS_KEY_PREFIX + member, address);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public String getUserAddress(String member) {
        if(member == null || member.isEmpty()){
            throw new IllegalArgumentException("获取地址参数错误");
        }
        return redisTemplate.opsForValue().get(ADDRESS_KEY_PREFIX + member);
    }

    @Override
    public Boolean deleteUserLocation(Integer userId) {
        if(userId == null || userId < 0){
            return false;
        }
        Long status = redisTemplate.opsForZSet().remove(CACHE_KEY, userId.toString());
        return status != null && status > 0;
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> listLocationsInRadius(String member, Double distance,
                                                                                  Metric metric, int limit) {
        if(member == null || member.isEmpty() || distance == null || distance <= 0 || metric == null || limit <= 0){
            return null;
        }
        // radius命令参数：距离、坐标、上限（避免附近用户过多）、升序排序（距离近靠前）
        RedisGeoCommands.GeoRadiusCommandArgs commandArgs = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeCoordinates()
                .includeDistance()
                .limit(limit)
                .sortAscending();
        // geoRadius操作，返回结果暂不处理
        return redisTemplate
                .opsForGeo()
                .radius(CACHE_KEY,member, new Distance(distance, metric), commandArgs);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> listLocationsInRadius(Double latitude, Double longitude,
                                                                                  Double distance, Metric metric, int limit) {
        if(invalidCoordinates(latitude, longitude) || distance == null || distance <= 0 || metric == null || limit <= 0){
            return null;
        }
        RedisGeoCommands.GeoRadiusCommandArgs commandArgs = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeCoordinates()
                .includeDistance()
                .limit(limit)
                .sortAscending();
        Point center = new Point(longitude, latitude);
        Distance radius = new Distance(distance, metric);
        return redisTemplate
                .opsForGeo()
                .radius(CACHE_KEY, new Circle(center, radius), commandArgs);
    }

    /**
     * 验证坐标是否合法，经度: -180~180、纬度：-90~90
     * @param latitude 纬度
     * @param longitude 经度
     * @return 是否合法
     */
    private Boolean invalidCoordinates(Double latitude, Double longitude){
        return latitude == null ||
                longitude == null ||
                Math.abs(latitude) > 90 ||
                Math.abs(longitude) > 180;
    }

    @Override
    public Double getDistanceBetween(Integer userId, Integer otherUserId) {
        if(userId == null || otherUserId == null || userId <= 0 || otherUserId <= 0){
            throw new IllegalArgumentException();
        }
        Distance distance = redisTemplate
                .opsForGeo()
                .distance(CACHE_KEY, userId.toString(), otherUserId.toString(), Metrics.NEUTRAL);

        return distance==null ? null : distance.getValue();
    }

    @Override
    public Map<String, Double> getUserLocation(Integer userId) {
        if(userId == null || userId <= 0){
            throw new IllegalArgumentException();
        }

        List<Point> points = redisTemplate.opsForGeo().position(CACHE_KEY, userId.toString());
        if(points == null){
            return null;
        }
        Map<String, Double> result = new HashMap<>(8);
        result.put("latitude", points.get(0).getY());
        result.put("longitude", points.get(0).getX());
        return result;
    }
}
