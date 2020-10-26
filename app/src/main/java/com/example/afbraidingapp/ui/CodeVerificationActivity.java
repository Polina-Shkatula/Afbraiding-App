package com.example.afbraidingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.example.afbraidingapp.R;

public class CodeVerificationActivity extends AppCompatActivity {
    Button button;
    PinView pinView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_verification);

        initUI();
    }

    private void initUI() {
        pinView = (PinView) findViewById(R.id.codeEdit);
        textView = (TextView) findViewById(R.id.tvIncorrectCode);
        button = (Button) findViewById(R.id.btnVerify);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pinView.getText() != null && pinView.getText().toString().equals("2501")){
                    openCreateAccount();
                }
                else{
                    textView.setVisibility(View.VISIBLE);
                    pinView.setItemBackground(ContextCompat.getDrawable(CodeVerificationActivity.this, R.drawable.bg_pin_btn_error));
                }
            }
        });

        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                button.setEnabled(length == 4);
                textView.setVisibility(View.GONE);
                pinView.setItemBackground(ContextCompat.getDrawable(CodeVerificationActivity.this, R.drawable.bg_pin_btn));
            }
        });
    }


    public void openCreateAccount(){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
}