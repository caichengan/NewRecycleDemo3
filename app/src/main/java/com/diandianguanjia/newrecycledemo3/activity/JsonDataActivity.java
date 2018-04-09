package com.diandianguanjia.newrecycledemo3.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.JsonBean;
import com.diandianguanjia.newrecycledemo3.utils.GetJsonDataUtil;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * @TODO<解析省市区数据示例>
 * @author 小嵩
 * @date 2017-3-16
 */
public class JsonDataActivity extends AppCompatActivity implements View.OnClickListener{


    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private boolean isLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_data);
        initView();
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread==null){//如果已创建就不再重新创建子线程了

                        Toast.makeText(JsonDataActivity.this,"Begin Parse Data",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(JsonDataActivity.this,"Parse Succeed",Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    Toast.makeText(JsonDataActivity.this,"Parse Failed",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    private void initView() {

        findViewById(R.id.btn_data).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_data:
                mHandler.sendEmptyMessage(MSG_LOAD_DATA);


                if (isLoaded){
                    ShowPickerView();
                }else {
                    Toast.makeText(JsonDataActivity.this,"Please waiting until the data is parsed",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_show:


                break;

        }

    }


    private void ShowPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()+
                        options2Items.get(options1).get(options2)+
                        options3Items.get(options1).get(options2).get(options3);

                Toast.makeText(JsonDataActivity.this,tx,Toast.LENGTH_SHORT).show();
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
        pvOptions.show();
    }

    private static final String TAG = "JsonDataActivity";

    /**
     * [
     {
     "name": "北京市",
     "city": [
     {
     "name": "北京市",
     "area": [
     "东城区",
     "西城区",
     "崇文区",
     "宣武区",
     "朝阳区",
     "丰台区",
     "石景山区",
     "海淀区",
     "门头沟区",
     "房山区",
     "通州区",
     "顺义区",
     "昌平区",
     "大兴区",
     "平谷区",
     "怀柔区",
     "密云县",
     "延庆县"
     ]
     }
     ]
     },
     {
     "name": "天津市",
     "city": [
     {
     "name": "天津市",
     "area": [
     "和平区",
     "河东区",
     "河西区",
     "南开区",
     "河北区",
     "红桥区",
     "塘沽区",
     "汉沽区",
     "大港区",
     "东丽区",
     "西青区",
     "津南区",
     "北辰区",
     "武清区",
     "宝坻区",
     "宁河县",
     "静海县",
     "蓟  县"
     ]
     }
     ]
     },
     {
     "name": "河北省",
     "city": [
     {
     "name": "石家庄市",
     "area": [
     "长安区",
     "桥东区",
     "桥西区",
     "新华区",
     "郊  区",
     "井陉矿区",
     "井陉县",
     "正定县",
     "栾城县",
     "行唐县",
     "灵寿县",
     "高邑县",
     "深泽县",
     "赞皇县",
     "无极县",
     "平山县",
     "元氏县",
     "赵  县",
     "辛集市",
     "藁",
     "晋州市",
     "新乐市",
     "鹿泉市"
     ]
     },
     {
     "name": "唐山市",
     "area": [
     "路南区",
     "路北区",
     "古冶区",
     "开平区",
     "新  区",
     "丰润县",
     "滦  县",
     "滦南县",
     "乐亭县",
     "迁西县",
     "玉田县",
     "唐海县",
     "遵化市",
     "丰南市",
     "迁安市"
     ]
     },
     {
     "name": "秦皇岛市",
     "area": [
     "海港区",
     "山海关区",
     "北戴河区",
     "青龙满族自治县",
     "昌黎县",
     "抚宁县",
     "卢龙县"
     ]
     },
     {
     "name": "邯郸市",
     "area": [
     "邯山区",
     "丛台区",
     "复兴区",
     "峰峰矿区",
     "邯郸县",
     "临漳县",
     "成安县",
     "大名县",
     "涉  县",
     "磁  县",
     "肥乡县",
     "永年县",
     "邱  县",
     "鸡泽县",
     "广平县",
     "馆陶县",
     "魏  县",
     "曲周县",
     "武安市"
     ]
     },
     {
     "name": "邢台市",
     "area": [
     "桥东区",
     "桥西区",
     "邢台县",
     "临城县",
     "内丘县",
     "柏乡县",
     "隆尧县",
     "任  县",
     "南和县",
     "宁晋县",
     "巨鹿县",
     "新河县",
     "广宗县",
     "平乡县",
     "威  县",
     "清河县",
     "临西县",
     "南宫市",
     "沙河市"
     ]
     },
     {
     "name": "保定市",
     "area": [
     "新市区",
     "北市区",
     "南市区",
     "满城县",
     "清苑县",
     "涞水县",
     "阜平县",
     "徐水县",
     "定兴县",
     "唐  县",
     "高阳县",
     "容城县",
     "涞源县",
     "望都县",
     "安新县",
     "易  县",
     "曲阳县",
     "蠡  县",
     "顺平县",
     "博野",
     "雄县",
     "涿州市",
     "定州市",
     "安国市",
     "高碑店市"
     ]
     },
     {
     "name": "张家口",
     "area": [
     "桥东区",
     "桥西区",
     "宣化区",
     "下花园区",
     "宣化县"
     ]
     }
     ]
     }
     ]
     */

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
}
