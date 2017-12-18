package com.diandianguanjia.newrecycledemo3.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.RecycleViewMyAdapter;
import com.diandianguanjia.newrecycledemo3.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 2017/7/31.
 */

public class RecycleListViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private List<String> mListData;
    private RecycleViewMyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_listview);


        String style = getIntent().getStringExtra("style");

        mListData=new ArrayList<>();
        for (int i = 0; i <30; i++) {
            mListData.add(i+"");
        }

        List<Integer> mHeights=new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            mHeights.add((int) ((100+Math.random())+10*i));
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

        if (style.equals("listview")){
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }else {
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        }


        //设置item增加和删除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecycleViewMyAdapter(style,mHeights,mListData,RecycleListViewActivity.this);

        /**
         * 实现RecycleView的item的点击效果
         */
        adapter.setOnItenClickListener(new RecycleViewMyAdapter.OnItenClickListener() {

            //单点击
            @Override
            public void onItenClick(View view, int position) {
                Toast.makeText(RecycleListViewActivity.this, "点击了第"+position+"条"+"数据"+((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }

            //长按点击
            @Override
            public void onItenLonfClick(View view, final int position) {
                //Toast.makeText(MainActivity.this, "长按了第"+position+"条"+"数据"+mListData.get(position), Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(RecycleListViewActivity.this).setTitle("确定要删除吗？").
                        setNegativeButton("取消",null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Toast.makeText(MainActivity.this, "---"+which, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, "---------------------"+position, Toast.LENGTH_SHORT).show();
                        adapter.removeData(position);

                    }
                }).show();

            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}
