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

public class CreateAccountActivity extends AppCompatActivity {
    Button button;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        editText1 = (EditText) findViewById(R.id.etName);
        editText2 = (EditText) findViewById(R.id.etEmail);
        button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((editText1 != null) && (editText2 != null)){
                    openNewActivity();
                }
                if(editText1 == null){
                    editText1.setError("Invalid number");
                }
                if(editText2 == null){
                    editText2.setError("Invalid number");
                }
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editText2 != null){
                    button.setEnabled(true);
                }
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, AddProfilePictureActivity.class);
        startActivity(intent);
    }
}