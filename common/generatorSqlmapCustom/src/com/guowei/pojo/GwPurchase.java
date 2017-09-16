package com.guowei.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GwPurchase {
    private Long id;

    private Long pid;

    private Integer number;

    private BigDecimal price;

    private Date created;

    private Long mid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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