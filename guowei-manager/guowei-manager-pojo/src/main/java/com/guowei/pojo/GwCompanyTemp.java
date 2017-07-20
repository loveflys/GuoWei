package com.guowei.pojo;

import java.util.Date;

public class GwCompanyTemp {
    private Long id;

    private Long mid;
    
    private String mname;

    private Long templateId;
    
    private String tname;

    private String companyName;

    private String companyAddr;

    private String companyContactname;

    private String companyContactposition;

    private String companyContactphone;

    private String companyContactwechat;

    private String companyContactwechatopenid;

    private Date created;

    private Date purchased;

    private Long did;
    
    private String dname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getTName() {
        return tname;
    }

    public void setTName(String tname) {
        this.tname = tname;
    }
    
    public String getMName() {
        return mname;
    }

    public void setMName(String mname) {
        this.mname = mname;
    }
    
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyContactname() {
        return companyContactname;
    }

    public void setCompanyContactname(String companyContactname) {
        this.companyContactname = companyContactname;
    }

    public String getCompanyContactposition() {
        return companyContactposition;
    }

    public void setCompanyContactposition(String companyContactposition) {
        this.companyContactposition = companyContactposition;
    }

    public String getCompanyContactphone() {
        return companyContactphone;
    }

    public void setCompanyContactphone(String companyContactphone) {
        this.companyContactphone = companyContactphone;
    }

    public String getCompanyContactwechat() {
        return companyContactwechat;
    }

    public void setCompanyContactwechat(String companyContactwechat) {
        this.companyContactwechat = companyContactwechat;
    }

    public String getCompanyContactwechatopenid() {
        return companyContactwechatopenid;
    }

    public void setCompanyContactwechatopenid(String companyContactwechatopenid) {
        this.companyContactwechatopenid = companyContactwechatopenid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getPurchased() {
        return purchased;
    }

    public void setPurchased(Date purchased) {
        this.purchased = purchased;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }
}