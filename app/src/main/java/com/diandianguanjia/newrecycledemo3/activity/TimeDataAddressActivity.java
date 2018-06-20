package com.diandianguanjia.newrecycledemo3.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.ProvinceAdapter;
import com.diandianguanjia.newrecycledemo3.adapter.SchoolAdapter;
import com.diandianguanjia.newrecycledemo3.mode.JsonBean;
import com.diandianguanjia.newrecycledemo3.mode.ProvinceList;
import com.diandianguanjia.newrecycledemo3.mode.SchoolList;
import com.diandianguanjia.newrecycledemo3.utils.GetJsonDataUtil;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;

/**
 * Created by an on 2017/12/18.
 */

public class TimeDataAddressActivity extends AppCompatActivity implements View.OnClickListener, CityPickerListener {

    private TextView tvTimeSelect1;
    private TextView tvTimeSelect2;
    private TextView tvTimeSelect3;
    private TextView tvTimeSelect4;
    private ListView province;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private boolean isLoaded = false;
    private CityPicker cityPicker;
    private ListView mSchoolListView;
    private TextView mTitle;
    private ListView mProvinceListView;
    private PopupWindow mPopWindow;
    private ProvinceAdapter mProvinceAdapter;
    private SchoolAdapter mSchoolAdapter;
    private AdapterView.OnItemClickListener itemListener;
    private View parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time_data_address);
        tvTimeSelect1 = (TextView) findViewById(R.id.address_select);
        tvTimeSelect2 = (TextView) findViewById(R.id.address_select2);
        tvTimeSelect3 = (TextView) findViewById(R.id.address_select3);
        tvTimeSelect4 = (TextView) findViewById(R.id.address_select4);


        tvTimeSelect1.setOnClickListener(this);
        tvTimeSelect2.setOnClickListener(this);
        tvTimeSelect3.setOnClickListener(this);
        tvTimeSelect4.setOnClickListener(this);

        cityPicker = new CityPicker(TimeDataAddressActivity.this, this);

        /**
         * ListView Item点击事件
         */
        //隐藏地区
//显示学校
        itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent == mProvinceListView) {
                    ProvinceList provinceName = (ProvinceList) mProvinceListView.getItemAtPosition(position);
                    String provinceId = provinceName.getProvinceId();
                    mTitle.setText("选择学校");
                    mProvinceListView.setVisibility(View.GONE);//隐藏地区
                    mSchoolListView.setVisibility(View.VISIBLE);//显示学校
                    loadSchool();
                } else if (parent == mSchoolListView) {
                    SchoolList schoolName = (SchoolList) mSchoolListView.getItemAtPosition(position);
                    //mSelectSchool.setText(schoolName.getSchoolName());
                    Toast.makeText(TimeDataAddressActivity.this, "雷："+schoolName.getSchoolName(), Toast.LENGTH_SHORT).show();
                    mPopWindow.dismiss();
                }
            }
        };

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.address_select:
                if (isLoaded){
                    ShowPickerView();
                }else {
                    Log.i(TAG, "run: "+isLoaded);
                }

                mHandler.sendEmptyMessage(MSG_LOAD_DATA);
                break;
            case R.id.address_select2:

                showAddressThreeView();

                break;
            case R.id.address_select3:

                showAddressTWOView();

                break;
            case R.id.address_select4:
                showAddressTimeDataView();

                break;
        }

    }

    private void showAddressTimeDataView() {

        /**
         * 第一步   添加  compile 'com.contrarywind:Android-PickerView:4.1.4'
         */

        /**
         * 第二步  添加初始方法 initTimePicker（）；
         *
         *
         *
         *
         private void initTimePicker() {
         //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         Calendar selectedDate = Calendar.getInstance();
         Calendar startDate = Calendar.getInstance();
         startDate.set(2015, 0, 23);
         Calendar endDate = Calendar.getInstance();
         endDate.set(2025, 11, 28);
         //时间选择器
         //时间选择器
         // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
         pvTime = new TimePickerBuilder(SubscribeOrderActivity.this, new OnTimeSelectListener() {
        @Override
        public void onTimeSelect(Date date, View v) {
        // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null

        try {

        ifBigerNowTime("",StringUtil.dateToLong(date));

        } catch (Exception e) {
        e.printStackTrace();
        }


        }
        }).setType(new boolean[]{true, true, true, true, true, false})
         .setLabel("年", "月", "日", "时", "分", "秒")
         .isCenterLabel(false)
         .setDividerColor(Color.DKGRAY)
         .setContentTextSize(21)
         .setDate(selectedDate)
         .setRangDate(startDate, endDate)
         .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
         .setDecorView(null)
         .build();

         }

         */


        /**
         * 第三步  pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view  完成时间弹框
         */

    }


    /**
     * 二级联动
     */
    private void showAddressTWOView() {

        initPopView();

    }

    /**
     * 开源三级联动
     */
    private void showAddressThreeView() {

        cityPicker.show();

    }

    private void showPopWindow()
    { mPopWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);}

    private void initPopView() {
        parent = this.getWindow().getDecorView();
        View popView = View.inflate(this, R.layout.view_select_province_list, null);
        mProvinceListView = (ListView) popView.findViewById(R.id.province);
        mSchoolListView = (ListView) popView.findViewById(R.id.school);
        mTitle = (TextView) popView.findViewById(R.id.list_title);
        mProvinceListView.setOnItemClickListener(itemListener);
        mSchoolListView.setOnItemClickListener(itemListener);

        mProvinceAdapter = new ProvinceAdapter(this);
        mProvinceListView.setAdapter(mProvinceAdapter);
        mSchoolAdapter = new SchoolAdapter(this);
        mSchoolListView.setAdapter(mSchoolAdapter);

        int width = getResources().getDisplayMetrics().widthPixels * 3 / 4;
        int height = getResources().getDisplayMetrics().heightPixels * 3 / 5;
        mPopWindow = new PopupWindow(popView, width, height);
        ColorDrawable dw = new ColorDrawable(0x30000000);
        mPopWindow.setBackgroundDrawable(dw);
        mPopWindow.setFocusable(true);
        mPopWindow.setTouchable(true);
        mPopWindow.setOutsideTouchable(true);//允许在外侧点击取消

        loadProvince();

        showPopWindow();
        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mPopWindow.dismiss();
            }
        });
    }


    private void loadProvince() {


        ArrayList<ProvinceList> listProrvice=new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            ProvinceList provinceList=new ProvinceList();
            provinceList.setProvinceId(i+"");
            provinceList.setProvinceName("中山市");

            listProrvice.add(provinceList);
        }


        mProvinceAdapter.setList(listProrvice);
        mProvinceAdapter.notifyDataSetChanged();


    }

    private void loadSchool() {
        ArrayList<SchoolList> lislistSchool=new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            SchoolList schoolList=new SchoolList();
            schoolList.setSchoolId(i+"");
            schoolList.setSchoolName("雷州市");

            lislistSchool.add(schoolList);
        }


        mSchoolAdapter.setList(lislistSchool);
        mSchoolAdapter.notifyDataSetChanged();


    }






    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread==null){//如果已创建就不再重新创建子线程了

                        Toast.makeText(TimeDataAddressActivity.this,"Begin Parse Data",Toast.LENGTH_SHORT).show();
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 写子线程中的操作,解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    Toast.makeText(TimeDataAddressActivity.this,"Parse Succeed",Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    Toast.makeText(TimeDataAddressActivity.this,"Parse Failed",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };


    private static final String TAG = "TimeDataAddressActivity";

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this,"province.json");//获取assets目录下的json文件数据


        Log.i(TAG, "------initJsonData:----- "+JsonData.toString());
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c=0; c<jsonBean.get(i).getCityList().size(); c++){//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        ||jsonBean.get(i).getCityList().get(c).getArea().size()==0) {
                    City_AreaList.add("");
                }else {

                    for (int d=0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);




    }

    private void ShowPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()+
                        options2Items.get(options1).get(options2)+
                        options3Items.get(options1).get(options2).get(options3);

                Log.i(TAG, "--onOptionsSelect:-- "+tx);


                Toast.makeText(TimeDataAddressActivity.this,tx,Toast.LENGTH_SHORT).show();
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(options1Items);//一级选择器*/
        //pvOptions.setPicker(options1Items, options2Items);//二级选择器
        //pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
        pvOptions.show();
    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    @SuppressLint("ShowToast")
    @Override
    public void getCity(String s) {
        Toast.makeText(this,"选择的地址"+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (cityPicker.isShow()) {
            cityPicker.close();
            return;
        }
        super.onBackPressed();
    }
}
