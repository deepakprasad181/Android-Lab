package com.example.program8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button btndel, btnstar, btnhash, btncall, btnsave;
    EditText txtphno;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.btn_one);
        b1.setOnClickListener(this);
        b2 =(Button)findViewById(R.id.btn_two);
        b2.setOnClickListener(this);
        b3 =(Button)findViewById(R.id.btn_three);
        b3.setOnClickListener(this);
        b4 =(Button)findViewById(R.id.btn_four);
        b4.setOnClickListener(this);
        b5 =(Button)findViewById(R.id.btn_five);
        b5.setOnClickListener(this);
        b6 =(Button)findViewById(R.id.btn_six);
        b6.setOnClickListener(this);
        b7 =(Button)findViewById(R.id.btn_seven);
        b7.setOnClickListener(this);
        b8 =(Button)findViewById(R.id.btn_eight);
        b8.setOnClickListener(this);
        b9 =(Button)findViewById(R.id.btn_nine);
        b9.setOnClickListener(this);
        b0 =(Button)findViewById(R.id.btn_zero);
        b0.setOnClickListener(this);
        btnstar =(Button)findViewById(R.id.btn_start);
        btnstar.setOnClickListener(this);
        btnhash =(Button)findViewById(R.id.btn_hash);
        btnhash.setOnClickListener(this);
        btncall =(Button)findViewById(R.id.btn_call);
        btncall.setOnClickListener(this);
        btnsave =(Button)findViewById(R.id.btn_save);
        btnsave.setOnClickListener(this);
        btndel =(Button)findViewById(R.id.btn_delete);
        btndel.setOnClickListener(this);
        txtphno =(EditText)findViewById(R.id.txt_phonenumber);
        txtphno.setText("");
    }
    public void onClick(View v)
    {   if(v.equals(b1))
            txtphno.append("1");
        else if(v.equals(b2))
            txtphno.append("2");
        else if(v.equals(b3))
            txtphno.append("3");
        else if(v.equals(b4))
            txtphno.append("4");
        else if(v.equals(b5))
            txtphno.append("5");
        else if(v.equals(b6))
            txtphno.append("6");
        else if(v.equals(b7))
            txtphno.append("7");
        else if(v.equals(b8))
            txtphno.append("8");
        else if(v.equals(b9))
            txtphno.append("9");
        else if(v.equals(b0))
            txtphno.append("0");
        else if(v.equals(btnstar))
            txtphno.append("*");
        else if(v.equals(btnhash))
            txtphno.append("#");
        else if(v.equals(btnsave))
        {   Intent contactIntent= new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, txtphno.getText().toString());
            startActivity(contactIntent);
        }
        else if(v.equals(btndel))
        {   String data= txtphno.getText().toString();
            if(data.length()>0)
            {   txtphno.setText(data.substring(0,data.length()-1));
            }
            else
            {   txtphno.setText("");
            }
        }
        else if(v.equals(btncall))
        {   String data = txtphno.getText().toString();
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+ data));
            startActivity(intent);
        }
    }
}