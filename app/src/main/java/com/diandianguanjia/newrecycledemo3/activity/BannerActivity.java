package com.diandianguanjia.newrecycledemo3.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.AdvBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by an on 2017/12/16.
 */

public class BannerActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);
        PagerIndicator pagerIndicator= (PagerIndicator) findViewById(R.id.custom_indicator);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);


        //initDatas();
        imageSlider();

    }

    /**
     * 轮播图的设置
     */

    private static final String TAG = "BannerActivity";
    private void imageSlider() {

       final List<AdvBean> avdList=new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            AdvBean bean=new AdvBean();



            bean.setId(i+"");
            bean.setImg_url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513570948556&di=46673801cc31e8d8cdb1bddfd3b1c676&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F3ac79f3df8dcd1008742b1cc788b4710b8122f04.jpg");
            avdList.add(bean);

            Log.i(TAG, "----success----adv: "+avdList.size());
        }


        mDemoSlider.removeAllSliders();

        Log.i(TAG, "adv--imageSlider: 111111111");
        for (int i = 0; i < avdList.size(); i++) {

            //TextSliderView

            DefaultSliderView textSliderView = new DefaultSliderView(this);
           /* textSliderView.description("");//设置标题
            textSliderView.image(avdList.get(i).getImg_url());//设置图片的网络地址*/


            textSliderView
                    .description("第"+i)
                    .image(avdList.get(i).getImg_url())
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //添加到布局中显示
            mDemoSlider.addSlider(textSliderView);
            final int finalI = i;

            //sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

            //sliderShow.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));


            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                        if (avdList.get(finalI).getImg_url()!=null){

                            Log.i(TAG, "onClick: 123-"+avdList.get(finalI).getId());
                        }

                }
            });
        }

        //其他设置
        //sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);//使用默认指示器，在底部显示
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        mDemoSlider.setDuration(5000);//停留时间
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
    }

    private void initDatas() {

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513570948556&di=46673801cc31e8d8cdb1bddfd3b1c676&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F3ac79f3df8dcd1008742b1cc788b4710b8122f04.jpg");
        url_maps.put("Big Bang Theory", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513570948556&di=9f5cd92e51b89010e206bc36b903163f&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcb8065380cd79123685ac09ea7345982b3b780a6.jpg");
        url_maps.put("House of Cards", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513570948556&di=9f5cd92e51b89010e206bc36b903163f&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcb8065380cd79123685ac09ea7345982b3b780a6.jpg");
        url_maps.put("Game of Thrones", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513570948556&di=dc8f6256917eaf2447d26193157f764c&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0e2442a7d933c895184aba91db1373f082020027.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.ic_launcher);
        file_maps.put("Big Bang Theory",R.drawable.ic_launcher);
        file_maps.put("House of Cards",R.drawable.ic_launcher);
        file_maps.put("Game of Thrones", R.drawable.ic_launcher);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}