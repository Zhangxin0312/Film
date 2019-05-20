package com.bw.movie.contract;

import java.util.HashMap;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:41
 * @Description：描述信息
 */
public interface ContractInterface {
    //登录view
    public interface LoginViewInterface{
        public void showLogin(Object o);
    }
    //注册view
    public interface RegViewInterface{
        public void showReg(Object o);
    }
    //p层
    public interface PresenterInterface{
        public void toLogin(String phone,String pwd);
        public void toRegist(String phone,String pwd,String nickName,String birthday,String email,int sex,String pwd2);
        //推荐影院
        public void toRecommend();
        //关注小心心
        public void toHeart(int cinemaId);
        //取消小心心
        public void toQuHeart(int cinemaId);
        //附近影院
        public void toNearCinema();

        //正在热映
        public void toZheng(int cinemaId,HashMap<String,Integer>map);
        //电影的详情
        public void toXiangQing(int cinemaId);
        //电影评论
        public void toPingLun(int cinemaId,int page,int count);
        //电影购票
        public void toGouPiao(int cinemaId,int movieId);
        //关注电影的列表
        public void toGuanZhu();
        //点赞
        public void toZan(int commentId);

    }
    //推荐影院V层
    public interface RecommendViewInterface{
        public void showResommend(Object o);
        public void showHeart(Object o);
        public void showQuHeart(Object o);
        public void showGuan(Object o);
    }
    //附近影院V
    public interface NearCinemaViewInterface{
        public void showNearCinema(Object o);
    }
    //推荐影院的详情
    public interface RecommendDetailsViewInterface{
        public void showRecommendDetails(Object o);
        public void showZheng(Object o);
        public void showXiangQing(Object o);
        public void showPingLun(Object o);
        public void showGou(Object o);
        public void showZan(Object o);

    }

}
