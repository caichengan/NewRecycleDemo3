package com.diandianguanjia.newrecycledemo3.mode;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by an on 2017/9/13.
 */

public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType;

    private Entity entity;
    private Entity11 entity11;

    public Entity11 getEntity11() {
        return entity11;
    }

    public void setEntity11(Entity11 entity11) {
        this.entity11 = entity11;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }


    public MultipleItem(int itemType, Entity data) {
        this.itemType = itemType;
        this.entity = data;
    }
    public MultipleItem(int itemType, Entity11 entity11) {
        this.itemType = itemType;
        this.entity11 = entity11;
    }


    @Override
    public int getItemType() {
        return itemType;
    }



}

