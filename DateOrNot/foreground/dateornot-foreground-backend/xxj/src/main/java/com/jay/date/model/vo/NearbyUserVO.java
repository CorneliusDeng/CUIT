package com.jay.date.model.vo;

/**
 * @author Jay
 */
public class NearbyUserVO {
    private Integer user_id;
    private String user_name;
    private Integer sex;
    private String birthday;
    private String introduction;
    private String head_image_url;
    private Double distance;
    private Double latitude;
    private Double longitude;


    public NearbyUserVO(Integer user_id, String user_name, Integer sex, String birthday, String introduction, String head_image_url, Double distance, Double latitude, Double longitude) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.sex = sex;
        this.birthday = birthday;
        this.introduction = introduction;
        this.head_image_url = head_image_url;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHead_image_url() {
        return head_image_url;
    }

    public void setHead_image_url(String head_image_url) {
        this.head_image_url = head_image_url;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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
        return "NearbyUserVO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", introduction='" + introduction + '\'' +
                ", head_image_url='" + head_image_url + '\'' +
                ", distance=" + distance +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
