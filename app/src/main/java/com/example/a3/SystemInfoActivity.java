package com.example.a3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SystemInfoActivity extends AppCompatActivity {

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
    }

    TextView orientation;//屏幕方向
    TextView navigation;//方向控制
    TextView touch;//控制方式
    TextView mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);

        //获取应用界面中的应用组件
        orientation = (TextView)findViewById(R.id.screenOrientation);
        navigation = (TextView)findViewById(R.id.navigationControl);
        touch = (TextView)findViewById(R.id.touchScreen);
        mnc = (TextView)findViewById(R.id.mncCode);

          //可以用按钮点击之后显示，也可以直接跳转显示
//        Button bn = (Button)findViewById(R.id.bn);
//        bn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

                //获取系统的configuration信息
                Configuration configuration = getResources().getConfiguration();

                String screenOrientation, navigationControl, touchScreen, mncCode;

                if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    screenOrientation = "横向屏幕";
                } else {
                    screenOrientation = "竖向屏幕";
                }

                if(configuration.orientation == Configuration.NAVIGATION_NONAV) {
                    navigationControl = "没有方向控制";
                } else if(configuration.orientation == Configuration.NAVIGATION_WHEEL) {
                    navigationControl = "滚轮控制方向";
                } else if(configuration.orientation == Configuration.NAVIGATION_DPAD) {
                    navigationControl = "方向键控制方向";
                } else {
                    navigationControl = "轨迹球控制方向";
                }

                if(configuration.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH) {
                    touchScreen = "无触摸屏";
                } else {
                    touchScreen = "支持触摸屏";
                }

                mncCode = configuration.mnc + "";

                navigation.setText(navigationControl);
                orientation.setText(screenOrientation);
                mnc.setText(mncCode);
                touch.setText(touchScreen);
//            }
//        });

    }
}