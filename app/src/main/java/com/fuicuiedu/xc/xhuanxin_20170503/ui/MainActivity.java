package com.fuicuiedu.xc.xhuanxin_20170503.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fuicuiedu.xc.xhuanxin_20170503.MyHelper;
import com.fuicuiedu.xc.xhuanxin_20170503.R;

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
        MyHelper.setLogin(false);
    }
}
