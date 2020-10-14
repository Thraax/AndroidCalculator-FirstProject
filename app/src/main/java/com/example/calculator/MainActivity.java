package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.calculator.R.id.operation;

public class MainActivity extends AppCompatActivity {

    private TextView operation;
    private EditText result;
    private EditText newNumber;
    private TextView operationView;

    // Variable to hold operands and type calculation

    private  Double operand1 = null;
    private  Double operand2 = null;
    Double numbersResult = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newNumber = (EditText)  findViewById(R.id.newnumber);
        result = (EditText)  findViewById(R.id.result);
        operation = (TextView) findViewById(R.id.operation);


        Button btn0 = (Button) findViewById(R.id.num0);
        Button btn1 = (Button) findViewById(R.id.num1);
        Button btn2 = (Button) findViewById(R.id.num2);
        Button btn3 = (Button) findViewById(R.id.num3);
        Button btn4 = (Button) findViewById(R.id.num4);
        Button btn5 = (Button) findViewById(R.id.num5);
        Button btn6 = (Button) findViewById(R.id.num6);
        Button btn7 = (Button) findViewById(R.id.num7);
        Button btn8 = (Button) findViewById(R.id.num8);
        Button btn9 = (Button) findViewById(R.id.num9);
        Button decimalBtn = (Button) findViewById(R.id.decimalbtn);
        Button clearbtn = (Button) findViewById(R.id.clearbtn);
        Button btn_add = (Button) findViewById(R.id.addbtn);
        Button btn_minus = (Button) findViewById(R.id.diffbtn);
        Button btn_divide = (Button) findViewById(R.id.dividebtn);
        Button btn_multy = (Button) findViewById(R.id.mulybtn3);
        Button btn_result = (Button) findViewById(R.id.resultbtn);
        Button neg_port = (Button) findViewById(R.id.neg_port);
        Button neg_land = (Button) findViewById(R.id.negLand);

        // Appending numbers on newNumber EditText
        View.OnClickListener appendNumbers = new View.OnClickListener() {
            @Override
            public void onClick(View view) {  // Method to append the numbers which user is typing

                Button tempButton = (Button) view;
                newNumber.append(tempButton.getText().toString());


            }
        };

        // Display the operation type

         View.OnClickListener operationType = new View.OnClickListener() {  // Method to hold the operation type

            @Override
            public void onClick(View view) {

                Button tempButton = (Button) view;

                    operation.setText(tempButton.getText().toString());


                    if (newNumber.getText().toString().equals("."))      // Checking from the validation of the first number user entered
                    {
                        newNumber.setText("");

                    } else if (newNumber.getText().toString().length() > 0) {        // if the length of string bigger than 0, So we have a number t

                        if (numbersResult == null) {
                            result.setText(newNumber.getText().toString());
                            newNumber.setText("");
                        }

                        else {               // if the code entered here so that's mean the user didn't enter any numbers yet to perform operations on them

                            result.setText(numbersResult.toString());

                        }

                    }

                }



        };

        // Display result

        View.OnClickListener resultDisplay = new View.OnClickListener() {   // Method that's responsible on display the correct result
            @Override
            public void onClick(View view) {

                Button resultBtn = (Button) view;



                if(newNumber.getText().toString().equals("."))     // Checking from the input validation
                {
                    newNumber.setText("");
                }

                else if( ( newNumber.getText().toString().length() > 0 ) && ( result.getText().toString().length() > 0 ) )
                {
                    operand1 = Double.parseDouble(result.getText().toString());
                    operand2 = Double.parseDouble(newNumber.getText().toString());

                    if(operation.getText().equals("+"))         //Check from the operation type
                        numbersResult = operand1 + operand2;

                    else if(operation.getText().equals("-"))
                        numbersResult = operand1 - operand2;

                    else if(operation.getText().equals("*"))
                        numbersResult = operand1 * operand2;

                    else if(operation.getText().equals("/"))
                        numbersResult = operand1 / operand2;


                    String resultString = numbersResult.toString();
                    result.setText(resultString);
                    newNumber.setText("");
                }

                else {

                    if (numbersResult == null) {
                        result.setText(newNumber.getText().toString());
                        newNumber.setText("");
                    }

                    else{

                        result.setText(numbersResult.toString());
                    }


                }

            }
        };

        // Clear operations

        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operation.setText("");
                result.setText("");
                newNumber.setText("");
                operand1 = null;
                operand2 = null;
                numbersResult = null;


            }
        };


        // Negative button

        View.OnClickListener negNumbers = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button negBtn = (Button) view;

                if(newNumber.getText().toString().length() == 0)
                {
                    newNumber.append("-");

                }


            }
        };


        btn0.setOnClickListener(appendNumbers);
        btn1.setOnClickListener(appendNumbers);
        btn2.setOnClickListener(appendNumbers);
        btn3.setOnClickListener(appendNumbers);
        btn4.setOnClickListener(appendNumbers);
        btn5.setOnClickListener(appendNumbers);
        btn6.setOnClickListener(appendNumbers);
        btn7.setOnClickListener(appendNumbers);
        btn8.setOnClickListener(appendNumbers);
        btn9.setOnClickListener(appendNumbers);
        decimalBtn.setOnClickListener(appendNumbers);
        clearbtn.setOnClickListener(clear);
        btn_add.setOnClickListener(operationType);
        btn_minus.setOnClickListener(operationType);
        btn_divide.setOnClickListener(operationType);
        btn_multy.setOnClickListener(operationType);
        btn_result.setOnClickListener(resultDisplay);

        if(neg_port != null)
            neg_port.setOnClickListener(negNumbers);

        if(neg_land != null)
            neg_land.setOnClickListener(negNumbers);







    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        operationView = findViewById(R.id.operation);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //findViewById(R.id.operation) = operationView;

    }
}