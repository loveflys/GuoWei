package com.guowei.pojo;

import java.util.Date;

public class GwProduct {
    private Long id;

    private String title;

    private String image;

    private Long price;

    private Long discountprice;

    private Long buyingprice;

    private Integer stock;

    private Date created;

    private Date updated;

    private Integer allsellcount;

    private Long cid;

    private Byte status;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Long discountprice) {
        this.discountprice = discountprice;
    }

    public Long getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(Long buyingprice) {
        this.buyingprice = buyingprice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Integer getAllsellcount() {
        return allsellcount;
    }

    public void setAllsellcount(Integer allsellcount) {
        this.allsellcount = allsellcount;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}