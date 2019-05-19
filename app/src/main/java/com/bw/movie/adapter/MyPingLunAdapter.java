package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.weiduyiyuan.R;
import com.bw.movie.bean.PingLunBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/16 19:04
 * @Description：描述信息
 */
public class MyPingLunAdapter extends RecyclerView.Adapter<MyPingLunAdapter.Holder>{
    List<PingLunBean.ResultBean> list;
    Context context;

    public MyPingLunAdapter(List<PingLunBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pinglun,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        Uri uri=Uri.parse(list.get(position).getCommentHeadPic());
        holder.simpleDraweeView.setImageURI(uri);
        holder.textView1.setText(list.get(position).getCommentUserName());
        holder.textView2.setText(list.get(position).getCommentContent());
        holder.textView4.setText(list.get(position).getGreatNum()+"");

        //将毫秒值转换为年月日导包import java.text.SimpleDateFormat;


        //设置毫秒值
        int date= (int) list.get(position).getCommentTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        // time为转换格式后的字符串
        String time = dateFormat.format(new Date(date));
        holder.textView3.setText(time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView textView1,textView2,textView3,textView4;
        public Holder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.p_simple);
            textView1=itemView.findViewById(R.id.p_text1);
            textView2=itemView.findViewById(R.id.p_text2);
            textView3=itemView.findViewById(R.id.p_text3);
            textView4=itemView.findViewById(R.id.p_text4);
        }
    }
}
