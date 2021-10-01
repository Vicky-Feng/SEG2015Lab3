package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum Operator{none,add,sub,mul,div,equal}
    private double num1=0, num2=0;
    private Operator op=Operator.none;
    private boolean point=false;
    private boolean clear=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNumber(View view) {
        //getting id from pressed buttons
        int click = view.getId();

        //getting text that display the numbers
        TextView screen = findViewById(R.id.screen);

        //Clear
        if (op == Operator.equal){
            op = Operator.none;
            screen.setText("");
        }
        if (clear){
            screen.setText("");
            clear = false;
        }

        //numbers
        switch (click) {
            case R.id.btn0:
                screen.setText(screen.getText() + "0");
                break;
            case R.id.btn1:
                screen.setText(screen.getText() + "1");
                break;
            case R.id.btn2:
                screen.setText(screen.getText() + "2");
                break;
            case R.id.btn3:
                screen.setText(screen.getText() + "3");
                break;
            case R.id.btn4:
                screen.setText(screen.getText() + "4");
                break;
            case R.id.btn5:
                screen.setText(screen.getText() + "5");
                break;
            case R.id.btn6:
                screen.setText(screen.getText() + "6");
                break;
            case R.id.btn7:
                screen.setText(screen.getText() + "7");
                break;
            case R.id.btn8:
                screen.setText(screen.getText() + "8");
                break;
            case R.id.btn9:
                screen.setText(screen.getText() + "9");
                break;
            case R.id.btnPoint:
                if (!point) {
                    screen.setText(screen.getText() + ".");
                    point = true;
                } else {
                    screen.setText(screen.getText() + ".");
                }
                break;
            default:
                screen.setText("ERROR");
                Log.d("ERROR", "ERROR:Unknown button was clicked");
                break;
        }
    }

        public void onClickOperation (View view){
            int click=view.getId();
            TextView screen=findViewById(R.id.screen);

            //clear
            if(click==R.id.btnClear){
                op= Operator.none;
                screen.setText("");
                num1=0;
                num2=0;
                clear=false;
                return;
            }
            String text=screen.getText().toString();
            double value=text.length()>0? Double.parseDouble(text):0;

            if(op==Operator.none){
                num1 = value;
                clear = true;
                switch (click){
                    case R.id.screen:
                        op = Operator.equal;
                        num1 = 0;
                        break;
                    case R.id.btnAdd:
                        op = Operator.add;
                        break;
                    case R.id.btnSub:
                        op = Operator.sub;
                        break;
                    case R.id.btnMul:
                        op = Operator.mul;
                        break;
                    case R.id.btnDiv:
                        op = Operator.div;
                        break;
                    case R.id.btnClear:
                        op = Operator.none;
                        break;
                }
            }
            else{
                double result=0;
                num2=value;
                switch (op){
                    case equal:
                        break;

                    case add:
                        result=num1+num2;
                        break;

                    case sub:
                        result=num1-num2;
                        break;

                    case mul:
                        result=num1*num2;
                        break;

                    case div:
                        result=num1/num2;
                        break;
                }
                num1 = result;
                op = Operator.none;
                if (result - (int)result != 0){
                    screen.setText(String.valueOf(result));
                }
                else {
                    screen.setText(String.valueOf((int)result));
                }
            }
    }
}