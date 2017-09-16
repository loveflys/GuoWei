package com.guowei.pojo;

import java.util.Date;

public class GwSupplier {
    private Long id;

    private Long mid;

    private String supplierName;

    private String supplierAddr;

    private String supplierContactname;

    private String supplierContactposition;

    private String supplierContactphone;

    private String supplierContactwechat;

    private Date created;

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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddr() {
        return supplierAddr;
    }

    public void setSupplierAddr(String supplierAddr) {
        this.supplierAddr = supplierAddr;
    }

    public String getSupplierContactname() {
        return supplierContactname;
    }

    public void setSupplierContactname(String supplierContactname) {
        this.supplierContactname = supplierContactname;
    }

    public String getSupplierContactposition() {
        return supplierContactposition;
    }

    public void setSupplierContactposition(String supplierContactposition) {
        this.supplierContactposition = supplierContactposition;
    }

    public String getSupplierContactphone() {
        return supplierContactphone;
    }

    public void setSupplierContactphone(String supplierContactphone) {
        this.supplierContactphone = supplierContactphone;
    }

    public String getSupplierContactwechat() {
        return supplierContactwechat;
    }

    public void setSupplierContactwechat(String supplierContactwechat) {
        this.supplierContactwechat = supplierContactwechat;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}