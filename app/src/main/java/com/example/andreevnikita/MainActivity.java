package com.example.andreevnikita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText teInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView2);
        teInput = (EditText)findViewById(R.id.plaintext);
        bControl = (Button) findViewById(R.id.button2);

        guess = (int) (Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v) {

        if (!gameFinished) {
            int inp = Integer.parseInt(teInput.getText().toString());
            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp == guess)
            {
                tvInfo.setText("В точку!");
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;

            }
        }
        else
        {
            guess = (int)Math.random()*100;
            bControl.setText("Ввести значение");
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
    }
}