package com.bw.movie.app;

import com.bw.movie.bean.GouBean;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.HeartBean;
import com.bw.movie.bean.NearCinemaBean;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.bean.QuHeartBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.ZanBean;
import com.bw.movie.bean.ZhengMovieBean;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/11 10:24
 * @Description：描述信息
 */
public interface Api {

    @FormUrlEncoded
    @POST
    public Observable<ResponseBody> post(@Url String url, @FieldMap HashMap<String,String> map);

    @FormUrlEncoded
    @POST
    public Observable<ResponseBody> rpost(@Url String url, @Field("nickName")String nickName,@Field("phone")String phone,@Field("pwd")String pwd,@Field("pwd2")String pwd2,@Field("sex")int sex,@Field("birthday")String birthday,@Field("email")String email);
    //推荐影院
    @GET
    public Observable<RecommendBean> get(@Url String url);

    //关注小心心
    @GET
    public Observable<HeartBean> getHeart(@Url String url,@Header("userId")int userid,@Header("sessionId")String sessionId);
    //取消小心心
    @GET
    public Observable<QuHeartBean> getQuHeart(@Url String url, @Header("userId")int userid, @Header("sessionId")String sessionId);
    //附近影院
    @GET
    public Observable<NearCinemaBean>getNear(@Url String url);
    //推荐影院的详情
    @GET
    public Observable<RecommendBean> getDetails(@Url String url,@Header("userId")int userid,@Header("sessionId")String sessionid);
    //正在放映的电影
    @GET
    public Observable<ZhengMovieBean> getZhengMovie(@Url String url,@QueryMap HashMap<String,Integer>map);
    //电影详情
    @GET
    public Observable<XiangQingBean> getXiangQing(@Url String url,@Header("userId")int userId,@Header("sessionId")String sessionId);

    //电影评论
    @GET
    public Observable<PingLunBean> getPingLun(@Url String url);
    //电影购票
    @GET
    public Observable<GouBean> getGou(@Url String url);
    //查询关注影院
    @GET
    public Observable<GuanZhuBean> getGuan(@Url String url,@Header("userId")int userId,@Header("sessionId")String sessionId);
    //影院点赞
    @POST
    public Observable<ZanBean> postZan(@Url String url,@Header("userId")int userId,@Header("sessionId")String sessionId);

}
