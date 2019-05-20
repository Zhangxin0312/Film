package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

<<<<<<< HEAD:app/src/main/java/com/bw/movie/MainActivity.java
import com.bw.movie.R;
=======
>>>>>>> 09131561689e4c8c2d0726b9df73c14ca2f4f677:app/src/main/java/com/bw/movie/MainActivity.java
import com.bw.movie.activity.GuideActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_qidong)
    TextView btnQidong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnQidong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
