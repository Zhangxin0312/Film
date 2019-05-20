package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.app.App;
import com.bw.movie.app.UrlAll;
import com.bw.movie.bean.GouBean;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.HeartBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NearCinemaBean;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.ZanBean;
import com.bw.movie.bean.ZhengMovieBean;
import com.bw.movie.util.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import rx.Observer;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:39
 * @Description：描述信息
 */
public class MyModel {
    MyCallBack myCallBack;
    MyCallBack1 myCallBack1;
    MyCallBack2 myCallBack2;
    MyCallBack3 myCallBack3;
    MyCallBack4 myCallBack4;
    MyCallBack5 myCallBack5;
    MyCallBack6 myCallBack6;
    MyCallBack7 myCallBack7;
    MyCallBack8 myCallBack8;
    MyCallBack9 myCallBack9;
    MyCallBack10 myCallBack10;
    MyCallBack11 myCallBack11;
    MyCallBack12 myCallBack12;

    public void postRequest(String phone, String pwd){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.doPost(UrlAll.Url_Login, phone, pwd, new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss","onerror"+e.getMessage());
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    Gson gson=new Gson();
                    LoginBean loginBean = gson.fromJson(string, LoginBean.class);
                    myCallBack.success(loginBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void postRequestt(String phone, String pwd, String nickName, String birthday, String email, int sex ,String pwd2){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.doRePost(UrlAll.Url_Regist,nickName,phone,pwd,pwd2,sex,birthday,email, new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    Gson gson=new Gson();
                    RegistBean registBean = gson.fromJson(string, RegistBean.class);
                    myCallBack1.success(registBean);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //推荐影院
    public void getRequest(){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.doGet(UrlAll.Url_All,UrlAll.Url_Recommend, new Observer<RecommendBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("ssss",e.getMessage());
                Log.e("aaa","onerror");
            }

            @Override
            public void onNext(RecommendBean recommendBean) {
                myCallBack2.success(recommendBean);
            }
        });
    }
    //关注小心心
    public void getHeartRequest(int cinemaId){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getHeart(UrlAll.Url_Heart + cinemaId, App.UserId, App.SessionId, new Observer<HeartBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HeartBean heartBean) {
               myCallBack3.success(heartBean);
            }
        });
    }
    //取消小心心
    public void getQuHeartRequest(int cinemaId){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getHeart(UrlAll.Url_QuHeart + cinemaId, App.UserId, App.SessionId, new Observer<HeartBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("aaa",e.getMessage());
            }

            @Override
            public void onNext(HeartBean heartBean) {
                myCallBack4.success(heartBean);
            }
        });
    }
    //附近影院
    public void getNearRequest(){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        Log.e("aaa","onearror");
        okHttpUtil.getNearCinema(UrlAll.Url_All,UrlAll.Url_Recommend, new Observer<NearCinemaBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("ssss",e.getMessage());
                Log.e("aaa","onerror");
            }

            @Override
            public void onNext(NearCinemaBean nearCinemaBean) {
                myCallBack5.success(nearCinemaBean);
            }
        });
    }
    //正在热映
    public void ZhengMovie(int cinemaId,HashMap<String,Integer>map){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getZheng(UrlAll.Url_Zheng + cinemaId, map, new Observer<ZhengMovieBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("www",e.getMessage());
            }

            @Override
            public void onNext(ZhengMovieBean zhengMovieBean) {
               myCallBack7.success(zhengMovieBean);
            }
        });
    }
    //电影的详情
    public void doXiangQing(int cinemaId){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getXaingQing(UrlAll.Url_Xiang + cinemaId, App.UserId, App.SessionId, new Observer<XiangQingBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(XiangQingBean xiangQingBean) {
                 myCallBack8.success(xiangQingBean);
            }
        });
    }
    //电影的评论
    public void getPingLun(int cinemaId,int pagr,int count){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getPingLun(UrlAll.Url_PingLun + cinemaId, new Observer<PingLunBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
               Log.e("ssss",e.getMessage());
            }

            @Override
            public void onNext(PingLunBean pingLunBean) {
                Log.e("cccc",pingLunBean.getMessage());
                myCallBack9.success(pingLunBean);
            }
        });
    }
    //电影购票
    public void getGouPiao(int cinemasId,int movieId){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getGou(UrlAll.Url_gou + "cinemasId=" + cinemasId + "&movieId=" + movieId, new Observer<GouBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GouBean gouBean) {
                myCallBack10.success(gouBean);
            }
        });
    }
    //查询电影关注影院
    public void getGuanZhu(){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getGuan(UrlAll.Url_guan, App.UserId, App.SessionId, new Observer<GuanZhuBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GuanZhuBean guanZhuBean) {
                 myCallBack11.success(guanZhuBean);
            }
        });
    }
    //电影的点赞
    public void getZan(int commentId){
        OkHttpUtil okHttpUtil=OkHttpUtil.getInstance();
        okHttpUtil.getZan(UrlAll.Url_zan + commentId, App.UserId, App.SessionId, new Observer<ZanBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ZanBean zanBean) {
                  myCallBack12.success(zanBean);
            }
        });
    }
    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }
    public void setMyCallBack1(MyCallBack1 myCallBack1) {
        this.myCallBack1 = myCallBack1;
    }
    public void setMyCallBack2(MyCallBack2 myCallBack2) {
        this.myCallBack2 = myCallBack2;
    }
    public void setMyCallBack3(MyCallBack3 myCallBack3) {
        this.myCallBack3 = myCallBack3;
    }
    public void setMyCallBack6(MyCallBack6 myCallBack6) {
        this.myCallBack6 = myCallBack6;
    }
    public void setMyCallBack5(MyCallBack5 myCallBack5) {
        this.myCallBack5 = myCallBack5;
    }
    public void setMyCallBack4(MyCallBack4 myCallBack4) {
        this.myCallBack4 = myCallBack4;
    }
    public void setMyCallBack7(MyCallBack7 myCallBack7) {
        this.myCallBack7 = myCallBack7;
    }
    public void setMyCallBack8(MyCallBack8 myCallBack8) {
        this.myCallBack8 = myCallBack8;
    }

    public void setMyCallBack12(MyCallBack12 myCallBack12) {
        this.myCallBack12 = myCallBack12;
    }

    public void setMyCallBack11(MyCallBack11 myCallBack11) {
        this.myCallBack11 = myCallBack11;
    }

    public void setMyCallBack9(MyCallBack9 myCallBack9) {
        this.myCallBack9 = myCallBack9;
    }

    public void setMyCallBack10(MyCallBack10 myCallBack10) {
        this.myCallBack10 = myCallBack10;
    }

    public interface MyCallBack{
        public void success(Object o);
    }
    public interface MyCallBack1{
        public void success(Object o);
    }
    public interface MyCallBack2{
        public void success(Object o);
    }
    public interface MyCallBack3{
        public void success(Object o);
    }
    public interface MyCallBack4{
        public void success(Object o);
    }
    public interface MyCallBack5{
        public void success(Object o);
    }
    public interface MyCallBack6{
        public void success(Object o);
    }
    public interface MyCallBack7{
        public void success(Object o);
    }
    public interface MyCallBack8{
        public void success(Object o);
    }
    public interface MyCallBack9{
        public void success(Object o);
    }
    public interface MyCallBack10{
        public void success(Object o);
    }
    public interface MyCallBack11{
        public void success(Object o);
    }
    public interface MyCallBack12{
        public void success(Object o);
    }
}
