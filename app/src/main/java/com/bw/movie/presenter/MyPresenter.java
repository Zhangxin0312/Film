package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.PingLunBean;
import com.bw.movie.contract.ContractInterface;
import com.bw.movie.model.MyModel;

import java.util.HashMap;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:43
 * @Description：描述信息
 */
public class MyPresenter<T> implements ContractInterface.PresenterInterface {
    T tt;
    MyModel myModel;

    public MyPresenter(T tt) {
        this.tt = tt;
        myModel=new MyModel();
    }

    @Override
    public void toLogin(String phone, String pwd) {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                ContractInterface.LoginViewInterface viewInterface= (ContractInterface.LoginViewInterface) tt;
                viewInterface.showLogin(o);
                Log.e("aaaa",o.toString());
            }
        });
        myModel.postRequest(phone,pwd);
    }

    @Override
    public void toRegist(String phone, String pwd, String nickName, String birthday, String email, int sex, String pwd2) {
        myModel.setMyCallBack1(new MyModel.MyCallBack1() {
            @Override
            public void success(Object o) {
                ContractInterface.RegViewInterface regViewInterface= (ContractInterface.RegViewInterface) tt;
                regViewInterface.showReg(o);
            }
        });
        myModel.postRequestt(phone, pwd,nickName,birthday,email,sex,pwd2);
    }

    @Override
    public void toRecommend() {
        myModel.setMyCallBack2(new MyModel.MyCallBack2() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendViewInterface recommendPresenter= (ContractInterface.RecommendViewInterface) tt;
                recommendPresenter.showResommend(o);
            }
        });
        myModel.getRequest();
    }

    @Override
    public void toHeart(int cinemaId) {
        myModel.setMyCallBack3(new MyModel.MyCallBack3() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendViewInterface recommendViewInterface= (ContractInterface.RecommendViewInterface) tt;
                recommendViewInterface.showHeart(o);
            }
        });
        myModel.getHeartRequest(cinemaId);
    }

    @Override
    public void toQuHeart(int cinemaId) {
        myModel.setMyCallBack4(new MyModel.MyCallBack4() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendViewInterface recommendViewInterface= (ContractInterface.RecommendViewInterface) tt;
                recommendViewInterface.showQuHeart(o);
            }
        });
        myModel.getQuHeartRequest(cinemaId);
    }

    @Override
    public void toNearCinema() {
        myModel.setMyCallBack5(new MyModel.MyCallBack5() {
            @Override
            public void success(Object o) {
                ContractInterface.NearCinemaViewInterface nearCinemaViewInterface= (ContractInterface.NearCinemaViewInterface) tt;
                nearCinemaViewInterface.showNearCinema(o);
            }
        });
        myModel.getNearRequest();
    }


    @Override
    public void toZheng(int cinemaId,HashMap<String, Integer> map) {
        myModel.setMyCallBack7(new MyModel.MyCallBack7() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendDetailsViewInterface recommendDetailsViewInterface= (ContractInterface.RecommendDetailsViewInterface) tt;
                recommendDetailsViewInterface.showZheng(o);
            }
        });
        myModel.ZhengMovie(cinemaId,map);
    }

    @Override
    public void toXiangQing(int cinemaId) {
        myModel.setMyCallBack8(new MyModel.MyCallBack8() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendDetailsViewInterface recommendDetailsViewInterface= (ContractInterface.RecommendDetailsViewInterface) tt;
                recommendDetailsViewInterface.showXiangQing(o);
            }
        });
        myModel.doXiangQing(cinemaId);
    }

    @Override
    public void toPingLun(int cinemaId,int pagr,int count) {
        myModel.setMyCallBack9(new MyModel.MyCallBack9() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendDetailsViewInterface recommendDetailsViewInterface= (ContractInterface.RecommendDetailsViewInterface) tt;
                PingLunBean beans= (PingLunBean) o;
                Log.e("pinglun", "success: "+beans.getResult().get(0).getCommentUserName() );
                recommendDetailsViewInterface.showPingLun(beans);
            }
        });
        myModel.getPingLun(cinemaId,pagr,count);
    }

    @Override
    public void toGouPiao(int cinemaId, int movieId) {
        myModel.setMyCallBack10(new MyModel.MyCallBack10() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendDetailsViewInterface recommendDetailsViewInterface= (ContractInterface.RecommendDetailsViewInterface) tt;
                recommendDetailsViewInterface.showGou(o);
            }
        });
        myModel.getGouPiao(cinemaId,movieId);
    }

    @Override
    public void toGuanZhu() {
        myModel.setMyCallBack11(new MyModel.MyCallBack11() {
            @Override
            public void success(Object o) {
                ContractInterface.RecommendViewInterface recommendViewInterface= (ContractInterface.RecommendViewInterface) tt;
                recommendViewInterface.showGuan(o);
            }
        });
        myModel.getGuanZhu();
    }

    @Override
    public void toZan(int commentId) {
        myModel.setMyCallBack12(new MyModel.MyCallBack12() {
            @Override
            public void success(Object o) {

            }
        });
        myModel.getZan(commentId);
    }


}
