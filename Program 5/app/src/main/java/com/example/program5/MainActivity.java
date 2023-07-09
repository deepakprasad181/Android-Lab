package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{   TextView txtcount;
    Button start, stop;
    int counter=0;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcount =(TextView)findViewById(R.id.lbl_text);
        start =(Button)findViewById(R.id.btn_start);
        stop =(Button)findViewById(R.id.btn_stop);
        stop.setOnClickListener(this);
        start.setOnClickListener(this);
    }
    public void onClick(View v)
    {   if(v.equals(start))
        {   counter=0;
            running=true;
            new MyCounter().start();
        }
        else if(v.equals(stop))
        {   running=false;
        }
    }
    Handler handler=new Handler()
    {   public void handleMessage(Message m)
        {   txtcount.setText(String.valueOf(m.what));
        }
    };
    class MyCounter extends Thread
    {   public void run()
        {   while(running)
            {   counter++;
                handler.sendEmptyMessage(counter);
                try
                {   Thread.sleep(1000);
                }
                catch(Exception e) { }
            }
        }
    }
}
