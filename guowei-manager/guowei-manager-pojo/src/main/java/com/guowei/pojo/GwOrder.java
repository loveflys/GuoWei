package com.guowei.pojo;

import java.util.Date;

public class GwOrder {
    private Long id;

    private Long companyId;

    private String companyName;

    private Long amount;

    private Date created;

    private Long uid;

    private String uname;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    /**
     * 1:待支付 2：支付成功 3支付失败
     * @param status
     */
    public Byte getStatus() {
        return status;
    }
    /**
     * 1:待支付 2：支付成功 3支付失败
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}