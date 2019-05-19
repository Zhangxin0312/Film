package com.bw.movie.app;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:59
 * @Description：描述信息
 */
public class App extends Application {
    public static Context context;
    public static String SessionId;
    public static int UserId;
    public static int CinemaId;
    public static int MovieId;
    public static long Birthday;
    public static long LastLoginTime;
    public static String NickName;
    public static String Phone;
    public static String Pwd;
    public static int Sex;
    public static String HeadPic;
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
}
