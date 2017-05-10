package com.fuicuiedu.xc.xhuanxin_20170503.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fuicuiedu.xc.xhuanxin_20170503.MyHelper;
import com.fuicuiedu.xc.xhuanxin_20170503.R;
import com.fuicuiedu.xc.xhuanxin_20170503.ui.user.SettingFragment;
import com.fuicuiedu.xc.xhuanxin_20170503.ui.user.TestFragment;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_vp)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    private FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                //会话
                case 0:
                    // TODO: 2017/5/10 0010 显示会话页面
                    return new TestFragment();
                // 通讯录
                case 1:
                    // TODO: 2017/5/10 0010 显示通讯录页面
                    return new TestFragment();
                //设置
                case 2:
                    //显示设置页面
                    return new SettingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    @OnClick({R.id.btn_conversation, R.id.btn_address_list, R.id.btn_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            //会话
            case R.id.btn_conversation:
                //显示会话页面
                viewPager.setCurrentItem(0);
                break;
            //通讯录
            case R.id.btn_address_list:
                //显示通讯录页面
                viewPager.setCurrentItem(1);
                break;
            //设置
            case R.id.btn_setting:
                //显示设置页面
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
