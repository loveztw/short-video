package com.miyo.pojo;

import javax.persistence.*;

public class Bgm {
    @Id
    private Integer id;

    private String name;

    private String author;

    private String poster;

    private String url;

    private Integer type;
    
    private Integer refCnt;

	/**
     * @return refCnt
     */
    public Integer getRefCnt() {
		return refCnt;
	}

    /**
     * @param refCnt
     */
	public void setRefCnt(Integer refCnt) {
		this.refCnt = refCnt;
	}

	/**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }


}