package com.diandianguanjia.newrecycledemo3.adapter;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.Entity;
import com.diandianguanjia.newrecycledemo3.mode.MultipleItem;

import java.util.List;

/**
 * Created by an on 2017/9/13.
 */

public class MuliteAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {



    public MuliteAdapter(List data) {
        super(data);
        //必须绑定type和layout的关系
        addItemType(MultipleItem.TEXT, R.layout.text_view);
        addItemType(MultipleItem.IMG, R.layout.image_view);

    }


    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv3, item.getEntity().getName());
                //helper.setText(R.id.imgtv, item.getEntity().getName());
                break;
            case MultipleItem.IMG:

                helper.setImageResource(R.id.img, R.drawable.mein);
                break;
        }
    }

}