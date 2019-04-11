package com.example.a3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class btn5Click extends Activity implements View.OnClickListener {

    private Context context;
    private TextView textView;

    public btn5Click(Context context, TextView tV) {
        this.context = context;
        textView = tV;
    }

    @Override
    public void onClick(View view) {
        textView.setVisibility(textView.VISIBLE);
        textView.setText("点击了采用外部类的监听器");
    }

}
