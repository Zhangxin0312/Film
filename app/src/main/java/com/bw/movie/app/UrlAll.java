package com.bw.movie.app;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:30
 * @Description：描述信息
 */
public class UrlAll {
    public static String Url_All="http://172.17.8.100/";
    public static String Url_Login="movieApi/user/v1/login";
    public static String Url_Regist="movieApi/user/v1/registerUser";
    public static String Url_Recommend="movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
    public static String Url_Heart="movieApi/cinema/v1/verify/followCinema?cinemaId=";
    public static String Url_QuHeart="movieApi/cinema/v1/verify/cancelFollowCinema?cinemaId=";
    //附近影院
    //public static String Url_Near_Cinema="movieApi/cinema/v1/findNearbyCinemas?";
    //推荐影院的详情
    public static String Url_Deatils="movieApi/cinema/v1/findNearbyCinemas?page=1&count=10&id=";
    //正在放映的电影
    public static String Url_Zheng="movieApi/movie/v1/findMovieListByCinemaId?cinemaId=";
    //电影详情
    public static String Url_Xiang="movieApi/cinema/v1/findCinemaInfo?cinemaId=";
    //电影评论
    public static String Url_PingLun="movieApi/cinema/v1/findAllCinemaComment?page=1&count=5&cinemaId=";
    //电影购票
    public static String Url_gou="movieApi/movie/v1/findMovieScheduleList?";
    //查询关注影院
    public static String Url_guan="movieApi/movie/v1/verify/findMoviePageList?";
    //点赞
    public static String Url_zan="movieApi/cinema/v1/verify/cinemaCommentGreat?";

}
