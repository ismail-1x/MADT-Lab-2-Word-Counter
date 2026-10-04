package com.example.mywordcalculation;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;
    Spinner spinnerMetric;
    Button btnCount;
    TextView txtResult;

    TextCounter textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        spinnerMetric = findViewById(R.id.spinnerMetric);
        btnCount = findViewById(R.id.btnCount);
        txtResult = findViewById(R.id.txtResult);

        textCounter = new TextCounter();

        String[] options = {
                "Sentences",
                "Words",
                "Characters",
                "Numbers"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        options
                );

        spinnerMetric.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countText();
            }
        });
    }

    public void countText() {

        String text = txtInput.getText().toString();

        if (text.trim().isEmpty()) {

            Toast.makeText(
                    this,
                    "Please enter some text.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        String selected = spinnerMetric.getSelectedItem().toString();

        int result = 0;

        if (selected.equals("Sentences")) {
            result = textCounter.countSentences(text);
        }

        if (selected.equals("Words")) {
            result = textCounter.countWords(text);
        }

        if (selected.equals("Characters")) {
            result = textCounter.countCharacters(text);
        }

        if (selected.equals("Numbers")) {
            result = textCounter.countNumbers(text);
        }

        txtResult.setText("Result: " + result);
    }
}