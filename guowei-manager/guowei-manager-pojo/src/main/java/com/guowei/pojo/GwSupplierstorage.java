package com.guowei.pojo;

import java.util.Date;

public class GwSupplierstorage {
    private Long id;

    private Long sid;

    private String storageName;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}