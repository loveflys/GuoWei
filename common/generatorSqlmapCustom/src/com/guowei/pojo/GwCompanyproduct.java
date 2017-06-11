package com.guowei.pojo;

public class GwCompanyproduct {
    private Long id;

    private Long companyId;

    private Long pid;

    private Integer stock;

    private Integer sellcount;

    private Long sellprice;

    private Byte storageracks;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSellcount() {
        return sellcount;
    }

    public void setSellcount(Integer sellcount) {
        this.sellcount = sellcount;
    }

    public Long getSellprice() {
        return sellprice;
    }

    public void setSellprice(Long sellprice) {
        this.sellprice = sellprice;
    }

    public Byte getStorageracks() {
        return storageracks;
    }

    public void setStorageracks(Byte storageracks) {
        this.storageracks = storageracks;
    }
}