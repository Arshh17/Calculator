package com.example.t00601261.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    Button button0,button1,button2,button3,button4,button5,
    button6,button7,button8,button9,buttonAdd,buttonSub,buttonMulti,
    buttonDiv,buttonDec,buttonClear,buttonEquals;
    EditText et;
    DecimalFormat Dformat;
    Boolean add,subtract,multiply,divide;
    String first,second;
    Double firstNumebr,secondNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = false;
        subtract = false;
        multiply = false;
        divide = false;
        et = (EditText) findViewById(R.id.EditTextFinal);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSubtract);
        buttonMulti = findViewById(R.id.buttonMultiply);
        buttonDiv = findViewById(R.id.buttonDivide);
        buttonDec = findViewById(R.id.buttonDecimal);
        buttonClear = findViewById(R.id.buttonClear);
        buttonEquals = findViewById(R.id.buttonEquals);


        initialize();

    }

    protected void initialize(){
        first="Empty";
        Dformat = new DecimalFormat("##.000");

        button0.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+0);
            }
        });
        button1.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+9);
            }
        });
        buttonDec.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                et.setText(input+".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearButtonClicked();
            }
        });

        buttonClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClearButtonLongClicked();
                return true;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddButtonClicked();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubButtonClicked();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DivButtonClicked();
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiButtonClicked();
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               EqualsButtonClicked();
            }
        });

    }

    private void EqualsButtonClicked() {
        try {
            if (add == true) {
                second = et.getText().toString();
                firstNumebr = Double.parseDouble(first);
                secondNumber = Double.parseDouble(second);
                et.setText(Double.toString(Double.parseDouble(Dformat.format(firstNumebr + secondNumber))));
                add = false;
            }
            else if (subtract == true) {
                second = et.getText().toString();
                firstNumebr = Double.parseDouble(first);
                secondNumber = Double.parseDouble(second);
                et.setText(Double.toString(Double.parseDouble(Dformat.format(firstNumebr - secondNumber))));
                subtract = false;
            }
            else if (multiply == true) {
                second = et.getText().toString();
                firstNumebr = Double.parseDouble(first);
                secondNumber = Double.parseDouble(second);
                //double finalno = firstNumebr*secondNumber;
                et.setText(Double.toString(Double.parseDouble(Dformat.format(firstNumebr*secondNumber))));
                multiply = false;
            }
            else if (divide == true) {
                second = et.getText().toString();
                firstNumebr = Double.parseDouble(first);
                secondNumber = Double.parseDouble(second);
               // double finalno = firstNumebr/secondNumber;
                if (secondNumber != 0) {
                    et.setText(Double.toString(Double.parseDouble(Dformat.format(firstNumebr/secondNumber))));
                } else {
                    et.setText("ERR");
                }
                divide = false;
            }
            first="Empty";
        } catch (NumberFormatException x){
            Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_LONG).show();
        }
    }

    private void MultiButtonClicked() {
        if(!first.equals("Empty")){
            EqualsButtonClicked();
        }
        first = et.getText().toString();
        multiply=true;
        et.setText("");
    }

    private void DivButtonClicked() {
        if(!first.equals("Empty")){
            EqualsButtonClicked();
        }
        first = et.getText().toString();
        divide=true;
        et.setText("");
    }

    private void SubButtonClicked() {
        if(!first.equals("Empty")){
            EqualsButtonClicked();
        }
        if (et.getText().toString().equals("")) {
            et.setText("-");
        } else {
            first = et.getText().toString();
            et.setText("");
            subtract = true;
        }
    }


    private void AddButtonClicked() {
        if(first==("Empty")) {
            first = et.getText().toString();
            add = true;
            et.setText("");
        }
        else{
            EqualsButtonClicked();
        }
    }

    private void ClearButtonClicked() {
        try {
            first = et.getText().toString();
            int length = first.length();
            et.setText(first.substring(0, length - 1));
        } catch (StringIndexOutOfBoundsException x){
            first=null;
            second=null;
            Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_LONG).show();
        }
    }

    private void ClearButtonLongClicked() {
        et.setText("");
        first=null;
        second=null;
    }





}
