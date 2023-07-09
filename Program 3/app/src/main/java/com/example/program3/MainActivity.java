package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtname;
    EditText txtpwd;
    Button btnsignup;
    String re = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = findViewById(R.id.txt_username);
        txtpwd = findViewById(R.id.txt_password);
        btnsignup = findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = txtname.getText().toString();
        String password = txtpwd.getText().toString();

        if (validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("user", username);
            bundle.putString("Lab@2018", password);
            Intent it = new Intent(this, Activity_login.class);
            it.putExtra("data", bundle);
            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
