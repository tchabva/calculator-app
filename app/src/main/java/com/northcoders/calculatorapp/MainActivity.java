package com.northcoders.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText numberOneEditText;
    EditText numberTwoEditText;
    TextView result;
    Button addNumbersButton;

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

        numberOneEditText = findViewById(R.id.editTextNumber1);
        numberTwoEditText = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.textViewResult);
        addNumbersButton = findViewById(R.id.button);

        addNumbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberOne = Integer.parseInt(numberOneEditText.getText().toString());
                int numberTwo = Integer.parseInt(numberTwoEditText.getText().toString());
                Log.i("Sum", String.valueOf(numberTwo + numberTwo));
                result.setText(String.valueOf(numberTwo + numberTwo));
            }
        });
    }
}