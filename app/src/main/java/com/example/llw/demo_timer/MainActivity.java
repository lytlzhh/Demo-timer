package com.example.llw.demo_timer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
               // Integer s = (Integer) msg.obj;
                if (msg.what!=0)
                {
                    textView.setText(""+msg.what);
                }else {
                    Toast.makeText(MainActivity.this, "倒计时完毕", Toast.LENGTH_SHORT).show();
                }

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Timer timee = new Timer();
                timee.schedule(new TimerTask() {
                    int i = 20;
                    @Override
                    public void run() {
                            Message message = new Message();
                            if( ( message.what = i)!=0)
                            {
                                handler.sendMessage(message);
                                i--;
                            }
                    }
                },1000,1000);//参数详解第一个参数是指任务类，第二个参数是指：用户在调用schedul方法后，隔多长时间才执行run方法，第三个参数是指：每次回调run方法的间隔

            }
        });

    }


}
