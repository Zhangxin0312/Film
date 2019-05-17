package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.MyFragmentPagerAdapter;
import com.bw.movie.fragment.FilmFragment;
import com.bw.movie.fragment.MyFragment;
import com.bw.movie.fragment.ShouYeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        list.add(new ShouYeFragment());
        list.add(new FilmFragment());
        list.add(new MyFragment());
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_rb1:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.btn_rb2:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.btn_rb3:
                        viewPager.setCurrentItem(2,false);
                        break;
                }
            }
        });

    }
}
