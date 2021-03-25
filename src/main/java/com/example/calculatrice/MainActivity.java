package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClicked;
    Boolean firstClick = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void collapseCollumns(){
    }

    void addStyle(){

    }

    public void buttonClicked(View view) {
        btnClicked = (Button)view;
        String btnText = (String) btnClicked.getText();
        modifyExpression();
    }

    private void modifyExpression() {
        TextView expression = findViewById(R.id.expression);
        if(firstClick){
            expression.setText("");
            firstClick = false;
        }
        if(btnClicked.getId() == "@+id/btnAC")
        expression.setText((String)expression.getText()+ (String)btnClicked.getText());
    }
}