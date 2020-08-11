package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView number1 , number2 , ansNo1 , ansNo2 , answer , sign;
    private Button buttonPlus , buttonSub , buttonMult , buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        number1 = (TextView)findViewById(R.id.revNo1);
        number2 = (TextView)findViewById(R.id.revNo2);
        ansNo1 = (TextView)findViewById(R.id.AnsNo1);
        ansNo2 = (TextView)findViewById(R.id.AnsNo2);
        answer = (TextView)findViewById(R.id.Answer);
        sign = (TextView)findViewById(R.id.signBtn);

        buttonPlus = (Button)findViewById(R.id.addBtn);
        buttonSub = (Button)findViewById(R.id.subBtn);
        buttonMult = (Button)findViewById(R.id.multBtn);
        buttonDiv = (Button)findViewById(R.id.divBtn);

        Intent intent1 = getIntent();
        String Number1 = intent1.getStringExtra("number1");
        String Number2 = intent1.getStringExtra("number2");

        number1.setText(Number1);
        ansNo1.setText(Number1);
        number2.setText(Number2);
        ansNo2.setText(Number2);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValues();
                String clickMsg = "Adding two Numbers";
                Toast.makeText(getApplicationContext(),clickMsg,Toast.LENGTH_LONG).show();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                substractValues();
                String clickMsg = "Subtracting two numbers";
                Toast.makeText(getApplicationContext(),clickMsg,Toast.LENGTH_LONG).show();
            }
        });
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multipleValues();
                String clickMsg = "Multiplying two numbers";
                Toast.makeText(getApplicationContext(),clickMsg,Toast.LENGTH_LONG).show();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divideValues();
                String clickMsg = "Dividing two numbers";
                Toast.makeText(getApplicationContext(),clickMsg,Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addValues(){
        int value1 = Integer.parseInt(number1.getText().toString());
        int value2 = Integer.parseInt(number2.getText().toString());
        int ansValue = value1 + value2;
        answer.setText(String.valueOf(ansValue));
        sign.setText("+");
    }
    public void substractValues(){
        int value1 = Integer.parseInt(number1.getText().toString());
        int value2 = Integer.parseInt(number2.getText().toString());
        int ansValue = value1 - value2;
        answer.setText(String.valueOf(ansValue));
        sign.setText("-");
    }
    public void multipleValues(){
        int value1 = Integer.parseInt(number1.getText().toString());
        int value2 = Integer.parseInt(number2.getText().toString());
        int ansValue = value1 * value2;
        answer.setText(String.valueOf(ansValue));
        sign.setText("*");
    }
    public void divideValues(){
        int value1 = Integer.parseInt(number1.getText().toString());
        int value2 = Integer.parseInt(number2.getText().toString());
        if(value2 == 0){
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.custom_layout_1,(ViewGroup)findViewById(R.id.custom_toast_layout));

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.setView(layout);
            toast.show();
        }
        float ansValue = (int)value1 / (float)value2;
        answer.setText(String.valueOf(ansValue));
        sign.setText("/");
    }

}