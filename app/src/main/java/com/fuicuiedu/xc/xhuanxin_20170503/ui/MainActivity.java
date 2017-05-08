package com.fuicuiedu.xc.xhuanxin_20170503.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fuicuiedu.xc.xhuanxin_20170503.MyHelper;
import com.fuicuiedu.xc.xhuanxin_20170503.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_btn_loginout)
    public void loginout(){
        final ProgressDialog pb = new ProgressDialog(this);
        pb.setMessage("正在退出......");
        pb.show();

        EMClient.getInstance().logout(true, new EMCallBack() {
            @Override
            public void onSuccess() {
                pb.dismiss();
                MyHelper.setLogin(false);
                startActivity(new Intent(MainActivity.this,SplashActivity.class));
                finish();
            }

            @Override
            public void onProgress(int progress, String status) {
            }

            @Override
            public void onError(int code, String message) {
                handler.sendEmptyMessage(0);
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, "退出失败", Toast.LENGTH_SHORT).show();
        }
    };
}
