package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.Entity.EncryptUtil;
import com.bw.movie.R;
import com.bw.movie.app.App;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.ContractInterface;
import com.bw.movie.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ContractInterface.LoginViewInterface {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.btn_regist)
    TextView btnRegist;
    @BindView(R.id.btn_login)
    Button btnLogin;
    ContractInterface.PresenterInterface presenterInterface;
    @BindView(R.id.eye_id)
    ImageView eyeId;
    @BindView(R.id.jzma_id)
    CheckBox jzmaId;
    @BindView(R.id.wxLogin)
    ImageView wxLogin;

    boolean isHideFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenterInterface = new MyPresenter<>(this);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = editPwd.getText().toString();
                String phone = editPhone.getText().toString();
                Log.e("aaa",pwd.toString()+phone.toString());
                String encrypt = EncryptUtil.encrypt(pwd);

                presenterInterface.toLogin(phone, encrypt);
                /*Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                startActivity(intent);*/

            }
        });
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        eyeId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isHideFirst==true){
//                    HideReturnsTransformationMethod instance=HideReturnsTransformationMethod.getInstance();
//                    editPwd.setTransformationMethod(instance);
//                    isHideFirst=false;
//
//                }else{
//                    PasswordTransformationMethod instance=PasswordTransformationMethod.getInstance();
//                    editPwd.setTransformationMethod(instance);
//                    isHideFirst=true;
//                }
//                int index=editPwd.getText().toString().length();
//                editPwd.setSelection(index);
//            }
//        });
    }

    @Override
    public void showLogin(Object o) {

        LoginBean loginBean = (LoginBean) o;
        LoginBean.ResultBean.UserInfoBean userInfo = loginBean.getResult().getUserInfo();
        if (loginBean.getMessage().equals("登陆成功")) {
            App.UserId = loginBean.getResult().getUserId();
            App.SessionId = loginBean.getResult().getSessionId();
            App.Phone = editPhone.getText().toString();
            App.Pwd = editPwd.getText().toString();
            App.Birthday =userInfo.getBirthday();
            App.HeadPic = userInfo.getHeadPic();
            App.NickName = userInfo.getNickName();
            App.LastLoginTime = userInfo.getLastLoginTime();
            App.Sex = userInfo.getSex();


            Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
