package com.guowei.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GwProduct {
    private Long id;

    private String title;

    private String image;

    private BigDecimal price;

    private BigDecimal discountprice;

    private BigDecimal buyingprice;

    private Integer stock;

    private Integer distribute;

    private Integer allsellcount;

    private Date created;

    private Date updated;

    private Long cid;

    private String cname;

    private Byte status;

    private Long sid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    public BigDecimal getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(BigDecimal buyingprice) {
        this.buyingprice = buyingprice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getDistribute() {
        return distribute;
    }

    public void setDistribute(Integer distribute) {
        this.distribute = distribute;
    }

    public Integer getAllsellcount() {
        return allsellcount;
    }

    public void setAllsellcount(Integer allsellcount) {
        this.allsellcount = allsellcount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}