package com.bw.movie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.weiduyiyuan.R;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/15 9:53
 * @Description：描述信息
 */
public class XiangQingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_xiangqing,container,false);
        return view;
    }
}
