package com.diandianguanjia.newrecycledemo3.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;

import java.util.ArrayList;
import java.util.List;

import cc.duduhuo.dialog.smartisan.CustomizedDialog;
import cc.duduhuo.dialog.smartisan.NormalDialog;
import cc.duduhuo.dialog.smartisan.OptionListDialog;
import cc.duduhuo.dialog.smartisan.SmartisanDialog;
import cc.duduhuo.dialog.smartisan.ThreeOptionsDialog;
import cc.duduhuo.dialog.smartisan.TwoOptionsDialog;
import cc.duduhuo.dialog.smartisan.WarningDialog;
import cc.duduhuo.dialog.smartisan.listener.OnOptionItemSelectListener;

/**
 * Created by an on 2017/8/10.
 */

public class DialogActivity extends AppCompatActivity{


    private int select;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);
    }

    /**
     * 普通的Dialog
     *
     * @param view
     */
    public void normalDialog(View view) {
        final NormalDialog dialog = SmartisanDialog.createNormalDialog(this);
        dialog.setTitle("这是标题")
                .setMsg("对话框信息")
                .setMsgGravity(Gravity.CENTER)
                //.setLeftBtnBackground()
                .setLeftBtnText("取消")   // 设置文本的按钮会显示，不设置文本则不显示
                .setRightBtnText("确定")
                .show();
        // 设置点击监听（下同，不再解释）
        dialog.setOnSelectListener(new NormalDialog.OnSelectListener() {
            @Override
            public void onLeftSelect() {
                Toast.makeText(DialogActivity.this, "onLeftSelect", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onRightSelect() {
                Toast.makeText(DialogActivity.this, "onRightSelect", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    /**
     * 带两个选项的Dialog
     *
     * @param view
     */
    public void twoOptionsDialog(View view) {
        final TwoOptionsDialog dialog = SmartisanDialog.createTwoOptionsDialog(this);
        dialog.setTitle("选择一个选项")
                .setOp1Text("第一个选项")    // 设置第一个选项的文本
                .setOp2Text("第二个选项")    // 设置第二个选项的文本
                .show();
        dialog.setOnSelectListener(new TwoOptionsDialog.OnSelectListener() {
            @Override
            public void onOp1() {
                Toast.makeText(DialogActivity.this, "onOp1", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onOp2() {
                Toast.makeText(DialogActivity.this, "onOp2", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    /**
     * 带三个选项的Dialog
     *
     * @param view
     */
    public void threeOptionsDialog(View view) {
        final ThreeOptionsDialog dialog = SmartisanDialog.createThreeOptionsDialog(this);
        dialog.setOp1Text("选项1")
                .setOp2Text("选项2")
                .setOp3Text("选项3")
                .show();
        dialog.setOnSelectListener(new ThreeOptionsDialog.OnSelectListener() {
            @Override
            public void onOp1() {
                Toast.makeText(DialogActivity.this, "onOp1", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onOp2() {
                Toast.makeText(DialogActivity.this, "onOp2", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onOp3() {
                Toast.makeText(DialogActivity.this, "onOp3", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
    /**
     * 警告Dialog
     *
     * @param view
     */
    public void warningDialog(View view) {
        final WarningDialog dialog = SmartisanDialog.createWarningDialog(this);
        dialog.setTitle("确定退出登录吗")
                .setConfirmText("退出登录")
                .show();
        dialog.setOnConfirmListener(new WarningDialog.OnConfirmListener() {
            @Override
            public void onConfirm() {
                Toast.makeText(DialogActivity.this, "onConfirm", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    /**
     * 选项列表Dialog
     *
     * @param view
     */
    public void optionListDialog(View view) {
        List<String> options = new ArrayList<>(6);
        options.add("选项1");
        options.add("选项2");
        options.add("选项3");
        options.add("选项4");
        options.add("选项5");
        options.add("选项6");
        final OptionListDialog dialog = SmartisanDialog.createOptionListDialog(this);
        dialog.setTitle("请选择一个选项")
                .setOptionList(options)
                .setLastOption("选项5")   // 上次选择的选项
                .setItemGravity(Gravity.CENTER) // Item是居左、居中还是居右
                .setLastColor(0xFF40B64A)   // 上次选择的选项显示的颜色，用于区分
                .show();
        // setOnOptionItemSelectListener()方法必须在show()方法之后调用，否则无效
        dialog.setOnOptionItemSelectListener(new OnOptionItemSelectListener() {
            @Override
            public void onSelect(int position, CharSequence option) {
                Toast.makeText(DialogActivity.this, "position = " + position + ", option = " + option, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }

    /**
     * 自定义内容视图的Dialog
     *
     * @param view
     */
    public void customizedDialog1(View view) {
        final CustomizedDialog dialog = SmartisanDialog.createCustomizedDialog(this);
        View rootView = getLayoutInflater().inflate(R.layout.test_view, null);
        dialog.addView(rootView)
                .setTitle("自定义内容视图")
                .show();
    }

    /**
     * 自定义内容视图的Dialog
     *
     * @param view
     */
    public void customizedDialog2(View view) {
        final CustomizedDialog dialog = SmartisanDialog.createCustomizedDialog(this);
        View rootView = getLayoutInflater().inflate(R.layout.test_view, null);
        dialog.addView(rootView)
                .setTitle("自定义内容视图")
                .setLeftBtnText("按钮1")  // 设置文本的按钮会显示，不设置文本则不显示
                .setRightBtnText("按钮2")
                .show();
        dialog.setOnSelectListener(new CustomizedDialog.OnSelectListener() {
            @Override
            public void onLeftSelect() {
                Toast.makeText(DialogActivity.this, "onLeftSelect", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onRightSelect() {
                Toast.makeText(DialogActivity.this, "onRightSelect", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }


    private static final String TAG = "DialogActivity";
    /**
     * 单选对话框
     * @param view
     */
    public  void customizedSingleDialog(View view){
        //通过builder构造器gouzao

        AlertDialog.Builder builder =new AlertDialog.Builder(this);

        builder.setTitle("选择你喜欢的水果");

        final String items[]={"香蕉","西瓜","黄瓜","哈密瓜","苹果"};

        //-1代表默认没有条目被选中
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //把选择到的条目取出来
                Log.i(TAG, "---onClick--: "+select);
                String item = items[select];
                Log.i(TAG, "---item--: "+item);
                    Toast.makeText(getApplicationContext(), "---" + item, Toast.LENGTH_LONG).show();
                    //关闭对话框
                dialog.dismiss();
            }
        });
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //把选择到的条目取出来
                select = which;
                String item=items[which];
                Toast.makeText(getApplicationContext(), item+"---", Toast.LENGTH_SHORT).show();
                //关闭对话框
                //dialog.dismiss();
            }
        });
//显示对话框
        builder.show();
    }


    /**
     * 多选按钮对话框
     * @param view
     */
    public  void customizedMutilDialog(View view){

        //通过构造器构造
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("请选择你喜欢的课程");
        final String items[]={"android","C","C++","C#","IOs","java","html"};

//用来判断条目是否被选中
        final boolean []checkedItems={true,false,true,false,false,false,false};
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            //条目的点击事件
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb=new StringBuffer();
                for(int i=0;i<checkedItems.length;i++){
                    //判断一下选中的
                    if(checkedItems[i]){
                        String fruit=items[i];
                        sb.append(fruit+" ");
                    }
                }
                Toast.makeText(getApplicationContext(), sb, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();

    }

    /**
     * 进度条对话框
     * @param view
     */
    public void customizedProgressDialog(View view){

        //通过构造器来构造
        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("正在玩命加载中。。。");
        //设置一下进度条的样式
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //最后一步一定要show()出来
        dialog.show();
        //创建一个子线程
        new Thread(){
            public void run(){
                //设置进度条的最大值
                dialog.setMax(100);
                //设置当前进度
                for(int i=0;i<=20;i++){
                    dialog.setProgress(i*5);
                    //睡眠一下
                    SystemClock.sleep(200);
                }
                dialog.show();
                dialog.dismiss();
            }}.start();
    }
}
