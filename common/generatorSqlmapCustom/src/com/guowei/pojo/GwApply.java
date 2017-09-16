package com.guowei.pojo;

import java.util.Date;

public class GwApply {
    private Long id;

    private String companyName;

    private String companyAddr;

    private String contactName;

    private String contactPhone;

    private Long uid;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}