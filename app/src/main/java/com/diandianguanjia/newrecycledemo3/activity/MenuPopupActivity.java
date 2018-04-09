package com.diandianguanjia.newrecycledemo3.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.diandianguanjia.newrecycledemo3.R;

/**
 * Created by an on 2018/4/8.
 */

public class MenuPopupActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView popupMenu;
    private float fontSize=15.0f;
    private View contentView;
    private PopupWindow mWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_menupop);

        TextView optionsMenu= (TextView) findViewById(R.id.optionsMenu);
        TextView contextMenu= (TextView) findViewById(R.id.contextMenu);
        popupMenu = (TextView) findViewById(R.id.PopupMenu);
        TextView PopupWindow= (TextView) findViewById(R.id.PopupWindow);
        TextView AlertDialog= (TextView) findViewById(R.id.AlertDialog);
        TextView CustomDialog= (TextView) findViewById(R.id.CustomDialog);
        TextView ListDialog= (TextView) findViewById(R.id.ListDialog);

        optionsMenu.setOnClickListener(this);
        contextMenu.setOnClickListener(this);
        popupMenu.setOnClickListener(this);
        PopupWindow.setOnClickListener(this);
        AlertDialog.setOnClickListener(this);
        CustomDialog.setOnClickListener(this);
        ListDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.optionsMenu:
                break;
            case R.id.contextMenu:


                break;
            case R.id.PopupMenu:

               showPopupMenuMethod();

                break;
            case R.id.PopupWindow:

                showPopupWindowMethod();

                break;
            case R.id.AlertDialog:
                break;
            case R.id.CustomDialog:
                break;
            case R.id.ListDialog:
                break;
        }

    }

    //PopupWindow使用
    private void showPopupWindowMethod() {

        //contentView 内容视图
        contentView = View.inflate(this, R.layout.content_popunwindow,null);

        mWindow = new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        //设置触摸popunwindow外面的区域是否可以使其消失
        mWindow.setOutsideTouchable(true);

        //设置其背景
       // mWindow.setBackgroundDrawable(back);
        //设置触摸时有响应
        mWindow.setTouchable(true);


    }

    //PopupMenu使用
    private void showPopupMenuMethod() {


        //anchor:锚点
        PopupMenu popup=new PopupMenu(this,popupMenu);
        getMenuInflater().inflate(R.menu.menu_main,popup.getMenu());

        //显示菜单
        popup.show();

        //处理菜单点击事件
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.toolbar_add:
                        fontSize+=5;
                        break;
                    case R.id.toolbar_sub:
                        fontSize-=5;
                        break;




                }

                popupMenu.setTextSize(fontSize);
                return false;
            }
        });


    }
}
