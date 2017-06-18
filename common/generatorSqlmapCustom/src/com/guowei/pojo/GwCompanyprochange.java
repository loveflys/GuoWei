package com.guowei.pojo;

import java.util.Date;

public class GwCompanyprochange {
    private Long id;

    private Long cpid;

    private Integer number;

    private Date created;

    private Long mid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpid() {
        return cpid;
    }

    public void setCpid(Long cpid) {
        this.cpid = cpid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}