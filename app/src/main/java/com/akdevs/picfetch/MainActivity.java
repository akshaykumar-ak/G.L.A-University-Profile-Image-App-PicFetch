package com.akdevs.picfetch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    WebView w1;
    EditText e1;
    String roll="191500082";
    int rollInt=191500082;
    String myurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.submit);
        b2 = findViewById(R.id.next);
        b3 = findViewById(R.id.previous);
        e1 = findViewById(R.id.rollNo);
        w1 = findViewById(R.id.web);
        if(!DetectConnection.checkInternetConnection(MainActivity.this)){
            Toast.makeText(MainActivity.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
        }
        else {
            w1.loadUrl("https://glauniversity.in:8103/191500082.jpg");
            Toast.makeText(MainActivity.this, "Developed By Akshay Kumar", Toast.LENGTH_LONG).show();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll = e1.getText().toString().trim();
                if(roll=="" || roll.length()!=9){
                    e1.setError("Enter Valid Roll No");
                }
                else {
                    rollInt=Integer.parseInt(roll);
                    myurl="https://glauniversity.in:8103/"+roll+".jpg";
                    if(!DetectConnection.checkInternetConnection(MainActivity.this)){
                        Toast.makeText(MainActivity.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        w1.loadUrl(myurl);
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollInt = rollInt+1;
                roll = String.valueOf(rollInt);
                e1.setText(roll);
                myurl="https://glauniversity.in:8103/"+roll+".jpg";
                if(!DetectConnection.checkInternetConnection(MainActivity.this)){
                    Toast.makeText(MainActivity.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
                else {
                    w1.loadUrl(myurl);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollInt = rollInt-1;
                roll = String.valueOf(rollInt);
                e1.setText(roll);
                myurl="https://glauniversity.in:8103/"+roll+".jpg";
                if(!DetectConnection.checkInternetConnection(MainActivity.this)){
                    Toast.makeText(MainActivity.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
                else {
                    w1.loadUrl(myurl);
                }
            }
        });
    }
}