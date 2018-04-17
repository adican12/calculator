package com.adidroid.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView calcScreen;
    private String Display = "";
    private String currentOperator = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcScreen = findViewById(R.id.calcView);
        calcScreen.setText(Display);
    }

    private void updateScreen(){
        calcScreen.setText(Display);
    }


    public void onDigitClicked(View v){
        if(result != ""){
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        Display += b.getText();
        updateScreen();
    }

    private boolean isOperator(char op){
        switch (op){
            case '+':
            case '-':
            case 'x':
            case '÷':return true;
            default: return false;
        }
    }


    public void onClickOperator(View v){
        if(Display == "") return;

        Button b = (Button)v;

        if(result != ""){
            String _display = result;
            clear();
            Display = _display;
        }

        if(currentOperator != ""){
            Log.d("CalcX", ""+Display.charAt(Display.length()-1));
            if(isOperator(Display.charAt(Display.length()-1))){
                Display = Display.replace(Display.charAt(Display.length()-1), b.getText().charAt(0));
                updateScreen();
                return;
            }else{
                getResult();
                Display = result;
                result = "";
            }
            currentOperator = b.getText().toString();
        }
        Display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    private void clear(){
        Display = "";
        currentOperator = "";
        result = "";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "x": return Double.valueOf(a) * Double.valueOf(b);
            case "÷": try{
                return Double.valueOf(a) / Double.valueOf(b);
            }catch (Exception e){
                Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }

    private boolean getResult(){
        if(currentOperator == "") return false;
        String[] operation = Display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1], currentOperator));
        return true;
    }

    public void onClickEqual(View v){
        if(Display == "") return;
        if(!getResult()) return;
        calcScreen.setText(Display + "\n" + String.valueOf(result));
    }


}










