package com.northcoders.calculatorapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText numberOneEditText;
    EditText numberTwoEditText;
    TextView resultTextView;
    Button operatorButton;
    Button clearButton;
    Spinner selectOperationSpinner;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // connecting vars to the activity_main.xml layout items
        context = getApplicationContext(); // gets the application context
        numberOneEditText = findViewById(R.id.editTextNumber1);
        numberTwoEditText = findViewById(R.id.editTextNumber2);
        resultTextView = findViewById(R.id.textViewResult);
        operatorButton = findViewById(R.id.operatorButton);
        clearButton = findViewById(R.id.clearButton);
        selectOperationSpinner = findViewById(R.id.operationSpinner);

        // The button calls a different method depend on its text
        operatorButton.setOnClickListener(view -> {
            switch (operatorButton.getText().toString()){
                case "Add":
                    addNumbers();
                    break;
                case "Subtract":
                    subtractNumbers();
                    break;
                case "Multiply":
                    multiplyNumbers();
                    break;
                case "Divide":
                    divideNumbers();
                    break;
            }
        });

        // Selects which operation is currently assigned to the operationButton
        selectOperationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                operatorButton.setText(selectOperationSpinner.getSelectedItem().toString());
                clearNumbers(); // clears the numbers and screen when changing operations
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

        // Will clear the numbers and result when clicked
        clearButton.setOnClickListener(view -> clearNumbers());
    }

    // divide numbers method
    private void divideNumbers() {
        try {
            int numberOne = Integer.parseInt(numberOneEditText.getText().toString());
            int numberTwo = Integer.parseInt(numberTwoEditText.getText().toString());
            Log.i("Divide", String.valueOf(numberOne / numberTwo));
            resultTextView.setText(String.valueOf(numberOne / numberTwo));
        }catch (NumberFormatException e){
            Toast.makeText(this.context, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }catch (ArithmeticException e){
            Toast.makeText(this.context, "Cannot divide by 0!", Toast.LENGTH_SHORT).show();
        }
    }

    // Multitply numbers method
    private void multiplyNumbers() {
        try {
            int numberOne = Integer.parseInt(numberOneEditText.getText().toString());
            int numberTwo = Integer.parseInt(numberTwoEditText.getText().toString());
            Log.i("Multiply", String.valueOf(numberOne * numberTwo));
            resultTextView.setText(String.valueOf(numberOne * numberTwo));
        }catch (NumberFormatException e){
            Toast.makeText(this.context, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }
    }

    // Subtract numbers method.
    private void subtractNumbers() {
        try {
            int numberOne = Integer.parseInt(numberOneEditText.getText().toString());
            int numberTwo = Integer.parseInt(numberTwoEditText.getText().toString());
            Log.i("Subtract", String.valueOf(numberOne - numberTwo));
            resultTextView.setText(String.valueOf(numberOne - numberTwo));
        }catch (NumberFormatException e){
            Toast.makeText(this.context, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }
    }

    // Add numbers method
    private void addNumbers(){
        try {
            int numberOne = Integer.parseInt(numberOneEditText.getText().toString());
            int numberTwo = Integer.parseInt(numberTwoEditText.getText().toString());
            Log.i("Add", String.valueOf(numberOne + numberTwo));
            resultTextView.setText(String.valueOf(numberOne + numberTwo));
        }catch (NumberFormatException e){
            Toast.makeText(this.context, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }
    }

    // clears the numbers and the result textView
    private void clearNumbers(){
        resultTextView.setText("0");
        numberOneEditText.setText(null);
        numberTwoEditText.setText(null);
    }
}