package com.example.afbraidingapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.afbraidingapp.R;

public class SignInActivity extends AppCompatActivity {
    Button button;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        button = (Button) findViewById(R.id.next_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        editText = (EditText) findViewById(R.id.et_phone);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                button.setEnabled(length == 12);
                if(length > 12) editText.setError("Invalid number");
            }
        });

    }
    public void openNewActivity(){
        Intent intent = new Intent(this, CodeVerificationActivity.class);
        startActivity(intent);
    }
}