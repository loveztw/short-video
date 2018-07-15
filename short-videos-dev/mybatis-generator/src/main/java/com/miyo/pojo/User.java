package com.miyo.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    private String id;

    private String username;

    private String password;

    @Column(name = "face_image")
    private String faceImage;

    private String nickname;

    @Column(name = "fans_count")
    private Integer fansCount;

    @Column(name = "follow_count")
    private Integer followCount;

    @Column(name = "receive_like_count")
    private Integer receiveLikeCount;

    private String sex;

    private Date birthday;

    private String signature;

    private Integer age;

    @Column(name = "constellation_id")
    private Integer constellationId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return face_image
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * @param faceImage
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return fans_count
     */
    public Integer getFansCount() {
        return fansCount;
    }

    /**
     * @param fansCount
     */
    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    /**
     * @return follow_count
     */
    public Integer getFollowCount() {
        return followCount;
    }

    /**
     * @param followCount
     */
    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    /**
     * @return receive_like_count
     */
    public Integer getReceiveLikeCount() {
        return receiveLikeCount;
    }

    /**
     * @param receiveLikeCount
     */
    public void setReceiveLikeCount(Integer receiveLikeCount) {
        this.receiveLikeCount = receiveLikeCount;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return constellation_id
     */
    public Integer getConstellationId() {
        return constellationId;
    }

    /**
     * @param constellationId
     */
    public void setConstellationId(Integer constellationId) {
        this.constellationId = constellationId;
    }
}