package com.bw.movie.app;

<<<<<<< HEAD
import android.content.Context;

import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.ShouBean;
import com.bw.movie.bean.ShowIngBean;
import com.bw.movie.bean.ShowOnBean;

import java.util.List;
=======
import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:59
 * @Description：描述信息
 */
<<<<<<< HEAD
public class App {
    public static Context context;
    public static String SessionId;
    public static int UserId;
=======
public class App extends Application {
    public static Context context;
    public static String SessionId;
    public static int UserId;
    public static int CinemaId;
    public static int MovieId;
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677
    public static long Birthday;
    public static long LastLoginTime;
    public static String NickName;
    public static String Phone;
    public static String Pwd;
    public static int Sex;
    public static String HeadPic;
<<<<<<< HEAD
    public  static List<ShouBean.ResultBean> list;
    public  static List<ShowIngBean.ResultBean> list1;
    public  static List<ShowOnBean.ResultBean> list2;
    public  static boolean flagg=false;
    public  static List<MovieScheduleListBean.ResultBean> list3;
    public  static String AppId;
=======
    public static int Windowswidth;
    public static String Ximage;
    public static String Xtitle;
    public static String Xname;

    public static String Chentime;
    public static String Chentimeend;
    public static String Chentitle;
    public static Double Chenprice;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Windowswidth = wm.getDefaultDisplay().getWidth();

    }
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677
}
