package com.fuicuiedu.xc.xhuanxin_20170503;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化环信SDK
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //初始化（快捷键 ctrl + P 看所需参数）
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
}
