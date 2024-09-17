package com.example.tugaspam3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private TextView solutionDisplay;

    private String currentInput = "";
    private String fullEquation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.result_tv);
        solutionDisplay = findViewById(R.id.solution_tv);

        initButtons();
    }

    private void initButtons() {
        MaterialButton button0 = findViewById(R.id.button_0);
        MaterialButton button1 = findViewById(R.id.button_1);
        MaterialButton button2 = findViewById(R.id.button_2);
        MaterialButton button3 = findViewById(R.id.button_3);
        MaterialButton button4 = findViewById(R.id.button_4);
        MaterialButton button5 = findViewById(R.id.button_5);
        MaterialButton button6 = findViewById(R.id.button_6);
        MaterialButton button7 = findViewById(R.id.button_7);
        MaterialButton button8 = findViewById(R.id.button_8);
        MaterialButton button9 = findViewById(R.id.button_9);


        MaterialButton buttonPlus = findViewById(R.id.button_plus);
        MaterialButton buttonMinus = findViewById(R.id.button_minus);
        MaterialButton buttonMultiply = findViewById(R.id.button_multiply);
        MaterialButton buttonDivide = findViewById(R.id.button_devide);
        MaterialButton buttonOpenBracket = findViewById(R.id.button_open_bracket);
        MaterialButton buttonCloseBracket = findViewById(R.id.button_close_bracket);


        MaterialButton buttonEqual = findViewById(R.id.button_equal);
        MaterialButton buttonClear = findViewById(R.id.button_ac);
        MaterialButton buttonComma = findViewById(R.id.button_comma);


        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialButton clickedButton = (MaterialButton) v;
                appendToEquation(clickedButton.getText().toString());
            }
        };


        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);


        buttonPlus.setOnClickListener(v -> appendToEquation("+"));
        buttonMinus.setOnClickListener(v -> appendToEquation("-"));
        buttonMultiply.setOnClickListener(v -> appendToEquation("×"));
        buttonDivide.setOnClickListener(v -> appendToEquation("÷"));
        buttonOpenBracket.setOnClickListener(v -> appendToEquation("("));
        buttonCloseBracket.setOnClickListener(v -> appendToEquation(")"));

        buttonEqual.setOnClickListener(v -> calculateResult());

        buttonClear.setOnClickListener(v -> clearDisplay());

        buttonComma.setOnClickListener(v -> appendToEquation("."));
    }


    private void appendToEquation(String value) {
        currentInput += value;
        fullEquation += value;
        solutionDisplay.setText(fullEquation);
    }


    private void calculateResult() {
        try {

            String expressionString = fullEquation.replace("×", "*").replace("÷", "/");


            Expression expression = new ExpressionBuilder(expressionString).build();


            double result = expression.evaluate();


            display.setText(String.valueOf(result));


            currentInput = String.valueOf(result);
            fullEquation = currentInput;
        } catch (Exception e) {
            display.setText("Error");
        }
    }


    private void clearDisplay() {
        currentInput = "";
        fullEquation = "";
        display.setText("");
        solutionDisplay.setText("");
    }
}
