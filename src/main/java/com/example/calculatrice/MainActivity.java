package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStyle();
    }

    void collapseCollumns(){
    }

    void addStyle(){
        for(int i=1;i<=7;i++){
            View operators = findViewById(R.id.op1);
            operators.setBackgroundColor(Color.GRAY);
        }
    }
}