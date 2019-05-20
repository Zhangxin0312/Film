<<<<<<< HEAD:app/src/main/java/com/bw/movie/activity/GuideActivity.java
﻿package com.bw.movie.activity;
=======
package com.bw.movie.activity;
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677:app/src/main/java/com/bw/movie/activity/GuideActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bw.movie.R;
import com.bw.movie.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.view_pager) 
    ViewPager viewPager;
    List<Integer> list = new ArrayList<>();
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                //1.获取当前页的下标
                int i = viewPager.getCurrentItem();
                //2.当前页下标++
                i++;
                //3.设置显示的页 aaa
                viewPager.setCurrentItem(i);
<<<<<<< HEAD:app/src/main/java/com/bw/movie/activity/GuideActivity.java
//                Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
//                startActivity(intent);
  




=======
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677:app/src/main/java/com/bw/movie/activity/GuideActivity.java
                //4.重新发送消息
                handler.sendEmptyMessageDelayed(0, 1500);
            }
        }

        ;
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        //添加图片到集合
        list.add(R.mipmap.yd);
        list.add(R.mipmap.aaa);
        list.add(R.mipmap.yo);
        list.add(R.mipmap.yt);
        //创建适配器
        MyPagerAdapter adapter = new MyPagerAdapter(list, GuideActivity.this);
        //设置
        viewPager.setAdapter(adapter);
        //设置监听器
        //5.切换页面,,,改变小圆点的位置
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(list.size()-1==position){
                        Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                }
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //自动无限轮播
        handler.sendEmptyMessageDelayed(0, 1500);

    }
}
