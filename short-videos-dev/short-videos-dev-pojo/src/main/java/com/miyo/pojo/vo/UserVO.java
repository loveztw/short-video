package com.miyo.pojo.vo;

import java.sql.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public class UserVO {
    private String id;

    private String username;

    @JsonIgnore
    private String password;

    private String faceImage;

    private String nickname;

    private Integer fansCount;

    private Integer followCount;

    private Integer receiveLikeCount;

    private String userToken;
    
    private String sex;

    private Date birthday;

    private String signature;
    
    private Integer age;

    @JsonIgnore
    private Integer constellationId;
    
    private String constellationName;
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

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

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

	public String getConstellationName() {
		return constellationName;
	}

	public void setConstellationName(String constellationName) {
		this.constellationName = constellationName;
	}
}