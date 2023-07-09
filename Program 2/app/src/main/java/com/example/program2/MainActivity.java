package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button add, sub, mul, div;
    Button clr, equal, dot;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.button_one);
        b1.setOnClickListener(this);
        b2 =(Button)findViewById(R.id.button_two);
        b2.setOnClickListener(this);
        b3 =(Button)findViewById(R.id.button_three);
        b3.setOnClickListener(this);
        b4 =(Button)findViewById(R.id.button_four);
        b4.setOnClickListener(this);
        b5 =(Button)findViewById(R.id.button_five);
        b5.setOnClickListener(this);
        b6 =(Button)findViewById(R.id.button_six);
        b6.setOnClickListener(this);
        b7 =(Button)findViewById(R.id.button_seven);
        b7.setOnClickListener(this);
        b8 =(Button)findViewById(R.id.button_eight);
        b8.setOnClickListener(this);
        b9 =(Button)findViewById(R.id.button_nine);
        b9.setOnClickListener(this);
        b0 =(Button)findViewById(R.id.button_zero);
        b0.setOnClickListener(this);
        add =(Button)findViewById(R.id.button_add);
        add.setOnClickListener(this);
        sub =(Button)findViewById(R.id.button_sub);
        sub.setOnClickListener(this);
        mul =(Button)findViewById(R.id.button_mul);
        mul.setOnClickListener(this);
        div =(Button)findViewById(R.id.button_div);
        div.setOnClickListener(this);
        clr =(Button)findViewById(R.id.button_clear);
        clr.setOnClickListener(this);
        equal =(Button)findViewById(R.id.button_equal);
        equal.setOnClickListener(this);
        dot =(Button)findViewById(R.id.button_dot);
        dot.setOnClickListener(this);
        result =(EditText)findViewById(R.id.txt_result);
        result.setText("");
    }
    public void onClick(View v)
    {   if(v.equals(b1))
            result.append("1");
        if(v.equals(b2))
            result.append("2");
        if(v.equals(b3))
            result.append("3");
        if(v.equals(b4))
            result.append("4");
        if(v.equals(b5))
            result.append("5");
        if(v.equals(b6))
            result.append("6");
        if(v.equals(b7))
            result.append("7");
        if(v.equals(b8))
            result.append("8");
        if(v.equals(b9))
            result.append("9");
        if(v.equals(b0))
            result.append("0");
        if(v.equals(dot))
            result.append(".");
        if(v.equals(clr))
            result.setText("");
        if(v.equals(equal))
        {   try
            {   String data = result.getText().toString();
                if (data.contains("/"))
                {   String[] operands = data.split("/");
                    if(operands.length==2)
                    {   double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double result = operand1 / operand2;
                        this.result.setText(String.valueOf(result));
                    }
                    else
                    {   Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                else if (data.contains("*"))
                {   String[] operands = data.split(Pattern.quote("*"));
                    if(operands.length==2)
                    {   double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double result = operand1 * operand2;
                        this.result.setText(String.valueOf(result));
                    }
                    else
                    {   Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_LONG).show();
                    }
                }
                else if (data.contains("+"))
                {   String[] operands = data.split(Pattern.quote("+"));
                    if(operands.length==2)
                    {   double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double result = operand1 + operand2;
                        this.result.setText(String.valueOf(result));
                    }
                    else
                    {   Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_LONG).show();
                    }
                }
                else if (data.contains("-"))
                {   String[] operands = data.split("-");
                    if(operands.length==2)
                    {   double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double result = operand1 - operand2;
                        this.result.setText(String.valueOf(result));
                    }
                    else
                    {   Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_LONG).show();
                    }
                }
            }
            catch(Exception e)
            {
                Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_LONG).show();
            }
        }
        if(v.equals(add))
            result.append("+");
        if(v.equals(sub))
            result.append("-");
        if(v.equals(mul))
            result.append("*");
        if(v.equals(div))
            result.append("/");
    }
}