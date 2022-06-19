package com.jay.date.controller;

import com.jay.date.model.dto.UserLocationDTO;
import com.jay.date.model.vo.NearbyUserVO;
import com.jay.date.service.GeoService;
import com.jay.date.service.NearbyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Jay
 */
@RestController
@RequestMapping("/location")
@CrossOrigin
public class UserLocationController {

    private final GeoService geoService;
    private final NearbyUserService nearbyUserService;

    private final Logger logger;

    @Autowired
    public UserLocationController(GeoService geoService, NearbyUserService nearbyUserService) {
        this.geoService = geoService;
        this.nearbyUserService = nearbyUserService;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    /**
     * 保存用户位置
     * @param userLocation 用户位置dto
     * @return 保存结果
     */
    @PostMapping()
    public Boolean saveUserLocation(@RequestBody UserLocationDTO userLocation){
        logger.info("保存用户位置信息：userId={}, latitude={}, longitude={}",
                userLocation.getUserId(), userLocation.getLatitude(), userLocation.getLongitude());
        String member = userLocation.getUserId().toString();
        return geoService.saveUserLocation(member, userLocation.getLatitude(), userLocation.getLongitude());
    }

    /**
     * 获取该用户附近的用户
     * @param userId 用户id
     * @param limit 获取数量
     * @return 附近用户集合
     */
    @GetMapping("/nearby/{userId}")
    public List<NearbyUserVO> listNearbyUsers(@PathVariable("userId") Integer userId,
                                              @RequestParam("limit") Integer limit){
        return nearbyUserService.listNearbyUsers(userId, limit);
    }

    /**
     * 获取某坐标附近的所有用户
     * @param latitude 纬度
     * @param longitude 经度
     * @param limit 获取数量
     * @return 附近用户集合
     */
    @GetMapping("/nearby")
    public List<NearbyUserVO> listNearbyUsers(@RequestParam(value = "latitude") Double latitude,
                                              @RequestParam(value = "longitude") Double longitude,
                                              @RequestParam(value = "limit") Integer limit){
        return nearbyUserService.listNearbyUsers(latitude, longitude, limit);
    }

    /**
     * 获取两个用户之间的距离
     * @param userId 用户1id
     * @param otherUserId 用户2 id
     * @return 距离 单位km
     */
    @GetMapping("/distance")
    public Double getDistanceBetween(@RequestParam(value = "userId") Integer userId,
                                     @RequestParam(value = "otherUserId") Integer otherUserId){
        try{
            return geoService.getDistanceBetween(userId, otherUserId);
        }
        catch (IllegalArgumentException e){
            logger.error("距离参数错误");
            return null;
        }
    }

    /**
     * 获取用户坐标
     * @param userId 用户id
     * @return 坐标点
     */
    @GetMapping("/{userId}")
    public Map<String, Double> getUserLocation(@PathVariable("userId") Integer userId){
        try{
            return geoService.getUserLocation(userId);
        }
        catch (IllegalArgumentException e){
            logger.error("获取坐标参数错误");
            return null;
        }
    }

    /**
     * 删除用户位置信息
     * @param userId 用户id
     * @return 删除状态
     */
    @DeleteMapping("/{userId}")
    public Boolean deleteUserLocation(@PathVariable Integer userId){
        return geoService.deleteUserLocation(userId);
    }

    @PostMapping("/address")
    public Boolean saveUserAddress(@RequestParam("userId") Integer userId, @RequestParam("address") String address){
        try{
            String member = userId.toString();
            logger.info("用户 userId={} 地址： {}", userId, address);
            return geoService.saveUserAddress(member, address);
        }catch (IllegalArgumentException e){
            return false;
        }
    }
    @GetMapping("/address")
    public String getUserAddress(@RequestParam("userId") Integer userId){
        try{
            return geoService.getUserAddress(userId.toString());
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
