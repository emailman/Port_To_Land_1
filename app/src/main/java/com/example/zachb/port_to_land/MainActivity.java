package com.example.zachb.port_to_land;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* Zachary Betters
   CIS 282
   Save Instance State App
   4/18/17 */

public class MainActivity extends AppCompatActivity {

    public double num1, num2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setText();
            }
        });
    }

    public void setText() {
        EditText numOne = (EditText) findViewById(R.id.numOne);
        EditText numTwo = (EditText) findViewById(R.id.numTwo);
        TextView result= (TextView) findViewById(R.id.txtResult);

        try{
            num1 = Double.parseDouble(numTwo.getText().toString());
            num2 = Double.parseDouble(numOne.getText().toString());
            sum = num1 + num2;
        }
        catch(Exception e) {
            result.setText("Error calculating result!");
        }
        result.setText("Result = " + Double.toString(sum));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("Num 1", num1);
        outState.putDouble("Num 2", num2);
        outState.putDouble("Sum", sum);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        num1 = savedInstanceState.getDouble("Num 1");
        num2 = savedInstanceState.getDouble("Num 2");
        sum = savedInstanceState.getDouble("Sum");

        setText();
    }
}