package com.diandianguanjia.newrecycledemo3.mode;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by an on 2017/8/10.
 */

public class Realmzz extends RealmObject
{

    public Realmzz(){}

    @PrimaryKey
    private String id;
    private String name;
    private String imgUrl;
    private  String price;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
