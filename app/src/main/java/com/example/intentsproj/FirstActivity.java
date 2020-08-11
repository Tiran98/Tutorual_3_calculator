package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button button;
    private EditText send_text_no1 , send_text_no2;
    String message = "You just clicked the OK button";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button = (Button)findViewById(R.id.buttonOk);
        send_text_no1 = (EditText)findViewById(R.id.sendNo1);
        send_text_no2 = (EditText)findViewById(R.id.sendNo2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

                String no1 = send_text_no1.getText().toString();
                String no2 = send_text_no2.getText().toString();

                Intent intent1 = new Intent(getApplicationContext(),SecondActivity.class);
                intent1.putExtra("number1",no1);
                intent1.putExtra("number2",no2);

                startActivity(intent1);
            }
        });
    }

    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}