package com.miyo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户对象", description="这是用户对象")
public class User {
	@ApiModelProperty(hidden=true)
    @Id
    private String id;

    @ApiModelProperty(value="用户名", name="username", example="Lee", required=true)
    private String username;

    @ApiModelProperty(value="密码", name="password", example="123456", required=true)
    private String password;

    @ApiModelProperty(value="头像地址", name="faceImage", example="/uid/face/faceimage.jpg")
    @Column(name = "face_image")
    private String faceImage;

    @ApiModelProperty(value="昵称", name="nickname", example="米柚")
    private String nickname;

    @ApiModelProperty(hidden=true)
    @Column(name = "fans_count")
    private Integer fansCount;

    @ApiModelProperty(hidden=true)
    @Column(name = "follow_count")
    private Integer followCount;

    @ApiModelProperty(hidden=true)
    @Column(name = "receive_like_count")
    private Integer receiveLikeCount;

    @ApiModelProperty(value="性别", name="sex", example="1")
    private String sex;

    @ApiModelProperty(value="生日", name="birthday", example="2011-01-02")
    private Date birthday;

    @ApiModelProperty(value="个性签名", name="signature", example="我很丑可是我很温柔")
    private String signature;

    @ApiModelProperty(hidden=true)
    private Integer age;

    @ApiModelProperty(hidden=true)
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getConstellationId() {
		return constellationId;
	}

	public void setConstellationId(Integer constellationId) {
		this.constellationId = constellationId;
	}
}