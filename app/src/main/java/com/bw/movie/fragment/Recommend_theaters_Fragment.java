package com.bw.movie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.RecommendAdapter;
import com.bw.movie.adapter.SpacesItemDecoration;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.QuHeartBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/13 10:38
 * @Description：描述信息
 */
public class Recommend_theaters_Fragment extends Fragment implements ContractInterface.RecommendViewInterface {
    ContractInterface.PresenterInterface presenterInterface;
    RecyclerView recyclerView;
    List<RecommendBean.ResultBean> list=new ArrayList<>();
    RecommendAdapter adapter;
    int space=15;
    List<GuanZhuBean.ResultBean> glist=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_recommend_theaters,container,false);
        recyclerView=view.findViewById(R.id.recommend_recycler);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenterInterface=new MyPresenter<>(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
         adapter=new RecommendAdapter(list,getActivity(),presenterInterface);
        recyclerView.setAdapter(adapter);
        presenterInterface.toRecommend();
        recyclerView.addItemDecoration(new SpacesItemDecoration(space));
        adapter.setMyId(new RecommendAdapter.MyId() {
            @Override
            public void succ(int id, boolean ischeck) {
                if(ischeck){
                    presenterInterface.toHeart(id);
                }else {
                    presenterInterface.toQuHeart(id);

                }

            }
        });


    }

    @Override
    public void showResommend(Object o) {
        RecommendBean recommendBean= (RecommendBean) o;
        List<RecommendBean.ResultBean> result = recommendBean.getResult();
        list.addAll(recommendBean.getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showHeart(Object o) {
        Toast.makeText(getActivity(),(String)o,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showQuHeart(Object o) {
        QuHeartBean quHeartBean= (QuHeartBean) o;
        if(quHeartBean.getMessage().equals("不能重复关注")){
            adapter.setMyId(new RecommendAdapter.MyId() {
                @Override
                public void succ(int id, boolean ischeck) {

                        presenterInterface.toQuHeart(id);

                }
            });
        }
        Toast.makeText(getActivity(),(String)o,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGuan(Object o) {
        GuanZhuBean guanZhuBean= (GuanZhuBean) o;
        glist.addAll(guanZhuBean.getResult());
    }
}
