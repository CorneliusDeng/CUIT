package com.jay.date.model.dto;

/**
 * @author Jay
 */
public class UserLocationDTO {
    private Integer userId;
    private Double latitude;
    private Double longitude;

    public UserLocationDTO(Integer userId, Double latitude, Double longitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UserLocationDTO{" +
                "userId=" + userId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
