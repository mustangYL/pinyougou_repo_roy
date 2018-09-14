package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TbPromotion implements Serializable{
    private Long id;

    private String activeScope;//

    private String description;
    
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startDate;//

//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endDate;//
    
    private String status;

    private String title;//

    private String titleImg;//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActiveScope() {
        return activeScope;
    }

    public void setActiveScope(String activeScope) {
        this.activeScope = activeScope == null ? null : activeScope.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }
}