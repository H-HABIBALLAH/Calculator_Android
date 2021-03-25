package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    Stack<Integer> numbersStack = new Stack<Integer>();
    Stack<String> operatorsStack = new Stack<String>();
    TextView expression;
    Integer numberToPrepare = 0;
    String operator = "";
    Button btnClicked;
    Boolean firstClick = true;
    Integer result = 0;
    Integer operand1,operand2;

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
        modifyExpression();
        if(!(btnClicked.getText().equals("+") || btnClicked.getText().equals("-") || btnClicked.getText().equals("/") || btnClicked.getText().equals("*") || btnClicked.getText().equals("=") || btnClicked.getText().equals("AC")))
            prepareInteger();
        else if(btnClicked.getText().equals("=")) {
            pushToNumbersStack();
            result = evaluate();
            System.out.println(result);
        }
        else{
            pushToNumbersStack();
            operator = (String)btnClicked.getText();
            if(!operatorsStack.isEmpty() && (operatorsStack.peek().equals("*") || operatorsStack.peek().equals("/")))
                evaluatePrecedence();
            pushToOperatorsStack();
        }
    }

    private void evaluatePrecedence() {
        operand2 = numbersStack.pop();
        operand1 = numbersStack.pop();
        if(operatorsStack.pop().equals("*"))
            numberToPrepare = operand1 * operand2;
        else
            numberToPrepare = operand1 / operand2;
        numbersStack.push(numberToPrepare);
        numberToPrepare = 0;
        System.out.println("Stack of numbers: "+numbersStack);
    }


    private int evaluate() {
        while (!operatorsStack.isEmpty()){
            operand2 = numbersStack.pop();
            operand1 = numbersStack.pop();
            operator = operatorsStack.pop();
            if(operator.equals("+"))
                numberToPrepare = operand1 + operand2;
            else if(operator.equals("-"))
                numberToPrepare = operand1 - operand2;
            numbersStack.push(numberToPrepare);
        }
        return numbersStack.pop();
    }

    private void modifyExpression() {
        expression = findViewById(R.id.expression);
        if(firstClick){
            expression.setText("");
            firstClick = false;
        }
        if( btnClicked.getText().equals("AC"))
        {
            expression.setText("0");
            firstClick = true;
            numberToPrepare = 0;
        }
        else
            expression.setText((String)expression.getText()+ (String)btnClicked.getText());
    }

    private void prepareInteger(){
        numberToPrepare = numberToPrepare*10 + Integer.valueOf((String)btnClicked.getText());
        System.out.println(numberToPrepare);
    }

    private void pushToNumbersStack(){
            numbersStack.push(numberToPrepare);
            numberToPrepare = 0;
    }

    private  void pushToOperatorsStack(){
        operatorsStack.push(operator);
    }
}