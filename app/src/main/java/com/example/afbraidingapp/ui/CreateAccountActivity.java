package com.example.afbraidingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
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

        initUI();
    }

    private void initUI() {
        editText1 = (EditText) findViewById(R.id.etName);
        editText2 = (EditText) findViewById(R.id.etEmail);

        button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!editText1.toString().isEmpty()) && (!editText2.toString().isEmpty())){
                    openAddProfilePicture();
                }
                if(editText1.toString().isEmpty()){
                    editText1.setError(getString(R.string.invalid_number));
                }
                if(editText2.toString().isEmpty()){
                    editText2.setError(getString(R.string.invalid_number));
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
                if(Patterns.EMAIL_ADDRESS.matcher(editText2.getText().toString()).matches()){
                    button.setEnabled(true);
                }
                else{
                    editText2.setError(getString(R.string.email_invalid));
                }
            }
        });
    }

    public void openAddProfilePicture(){
        Intent intent = new Intent(this, AddProfilePictureActivity.class);
        startActivity(intent);
    }
}