package com.fuicuiedu.xc.xhuanxin_20170503.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fuicuiedu.xc.xhuanxin_20170503.MyHelper;
import com.fuicuiedu.xc.xhuanxin_20170503.R;
import com.fuicuiedu.xc.xhuanxin_20170503.ui.user.LoginActivity;
import com.hyphenate.chat.EMClient;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //1.5s跳转到相应位置
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //判断登录状态，决定跳转的位置
                Intent intent;
                if (MyHelper.getLogin()){
                    //两个方法是为了保证进入主页面后本地会话和群组都 load 完毕。
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    //跳转到主页
                    intent = new Intent(SplashActivity.this,MainActivity.class);
                }else{
                    //跳转到登录页
                    intent = new Intent(SplashActivity.this,LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
