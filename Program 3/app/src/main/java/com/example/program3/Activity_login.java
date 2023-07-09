package com.example.program3;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Activity_login extends AppCompatActivity implements View.OnClickListener
{       EditText txtname, txtPwd;
        Button btnLogin;
        String user,pass;
        int count=0;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {       super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                txtname =(EditText) findViewById(R.id.txt_login_username);
                txtPwd =(EditText) findViewById(R.id.txt_login_password);
                btnLogin=(Button)findViewById(R.id.btn_login_signin);
                btnLogin.setOnClickListener(this);
                Bundle bundle=getIntent().getBundleExtra("data");
                user=bundle.getString("user");
                pass=bundle.getString("Lab@2018");
        }
        public void onClick(View v)
        {       String user1= txtname.getText().toString();
                String pass1= txtPwd.getText().toString();
                if(user.equals(user1)&&pass.equals(pass1))
                {       Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
                }
                else
                {       count++;
                        if(count==3)
                        {       btnLogin.setEnabled(false);
                                Toast.makeText(this, "Failed Login Attempts",Toast.LENGTH_LONG).show();
                        }
                        else
                        {       Toast.makeText(this,"Login Failed "+count,Toast.LENGTH_LONG).show();
                        }
                }
        }
}

