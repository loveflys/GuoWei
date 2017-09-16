package com.guowei.pojo;

import java.util.Date;

public class GwComplain {
    private Long id;

    private Long uid;

    private String content;

    private String contactPhone;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}