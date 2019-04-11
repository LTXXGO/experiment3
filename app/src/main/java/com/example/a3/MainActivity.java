package com.example.a3;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn7, btn8;

    @BindView(R.id.button6)
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //相当于Button btn6 = (Button) findViewById(R.id.button6);

        final TextView textView = findViewById(R.id.textView);
        textView.setVisibility(textView.GONE);

        //使用Activity作为监听器
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        //使用匿名内部类作为监听器
        //绑定button按钮
        btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(textView.VISIBLE);
                textView.setText("点击了采用匿名内部类的监听器");
            }
        });

        //定义内部类，实现OnClickListene接口
        class btn4Click implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                textView.setVisibility(textView.VISIBLE);
                textView.setText("点击了采用内部类作为监听器");
            }
        }
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new btn4Click());

        //使用外部类作为监听器
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new btn5Click(this, textView));
    }

    @Override
    public void onClick(View view) {
        final TextView textView = findViewById(R.id.textView);
        textView.setVisibility(textView.VISIBLE);
        textView.setText("点击了采用Activity作为监听器");
    }

    //使用绑定到标签的监听器
    public void btn3Click(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setVisibility(textView.VISIBLE);
        textView.setText("点击了采用绑定到标签的监听器");
    }

    //使用绑定到ButterKnife的监听器
    @OnClick(R.id.button6)
    public void btn6Click() {
        TextView textView = findViewById(R.id.textView);
        textView.setVisibility(textView.VISIBLE);
        textView.setText("点击了采用ButterKnife绑定的监听器");
    }

    //系统信息按钮
    public void btn7Click(View view) {
        Intent intent = new Intent(this, SystemInfoActivity.class);
        startActivity(intent);
        TextView textView = findViewById(R.id.textView);
        textView.setVisibility(textView.GONE);
    }

    public void btn8Click(View view) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMax(100);
        // 设置对话框的标题
        dialog.setTitle("任务完成百分比");
        // 设置对话框显示的内容
        dialog.setMessage("耗时任务的完成百分比");
        // 设置对话框不能用“取消”按钮关闭
        dialog.setCancelable(false);
        // 设置对话框的进度条风格
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // 设置对话框的进度条是否显示进度
        dialog.setIndeterminate(false);
        dialog.show();
    }
}
