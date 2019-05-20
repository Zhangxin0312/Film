package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.app.App;
import com.bw.movie.view.SeatTable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XuanZuoActivity extends AppCompatActivity {

    @BindView(R.id.gou_text_shi)
    TextView gouTextShi;
    @BindView(R.id.gou_text_shi_end)
    TextView gouTextShiEnd;
    @BindView(R.id.gou_text_ying)
    TextView gouTextYing;
    @BindView(R.id.movie_setview)
    SeatTable movieSetview;
    @BindView(R.id.PayMoney)
    TextView PayMoney;
    @BindView(R.id.PayTrue)
    ImageView PayTrue;
    @BindView(R.id.PayFalse)
    ImageView PayFalse;

    int s=0;
    ImageView image_qu;
    TextView text_sum;
    RadioButton radio_wei,radio_zhi;
    int type;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuan_zuo);
        ButterKnife.bind(this);
        gouTextShi.setText(App.Chentime);
        final TextView Money = findViewById(R.id.PayMoney);
        gouTextShiEnd.setText(App.Chentimeend);
        gouTextYing.setText(App.Chentitle);
        movieSetview.setScreenName(App.Chentitle);
        movieSetview.setMaxSelected(4);
        movieSetview.setSeatChecker(new SeatTable.SeatChecker() {
            @Override
            public boolean isValidSeat(int row, int column) {
                if (row == 4) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if (row == 6 && column == 6) {
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {
                //Log.e("tag",row+"----"+column);
                s++;
                Money.setText(s * App.Chenprice + "");
            }

            @Override
            public void unCheck(int row, int column) {
                //Log.e("tag",row+"****"+column);
                s--;
                // Log.e("tag","选中票数----"+s);
                Money.setText(s * App.Chenprice + "");
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        //int s = App.DrawSeat / 10;
        Log.e("tag", s + "");
        movieSetview.setData(5, 10);
        init();
    }

    private void init() {
        PayFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XuanZuoActivity.this,RecommendXiangActivity.class);
                startActivity(intent);
                finish();
            }
        });
        PayTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=View.inflate(XuanZuoActivity.this,R.layout.item_zhifu,null);
//                String signMd = App.userId+""+App.guGouId+""+s+"movie";
//                String sign =  md5Decode(signMd);
//                presenterIntface.toXiaDan(App.guGouId,s,sign);
                image_qu=view.findViewById(R.id.image_zhufu_qu);
                text_sum=view.findViewById(R.id.text_sum);
                radio_wei=view.findViewById(R.id.radio_weixin);
                radio_zhi=view.findViewById(R.id.radio_zhufubao);
                popupWindow=new PopupWindow(view,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,false);
                popupWindow.showAsDropDown(view);
                popupWindow.setFocusable(true);

                radio_wei.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        type=1;
                        text_sum.setText("微信支付"+s*App.Chenprice+"元");
                    }
                });
                radio_zhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        type=2;
                        text_sum.setText("支付宝支付"+s*App.Chenprice+"元");
                    }
                });
                image_qu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });

    }
}
