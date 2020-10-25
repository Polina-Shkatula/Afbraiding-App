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
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence == null || charSequence.length() == 0) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j<charSequence.length(); j++) {
                    if (j != 3 && j != 8 && charSequence.charAt(j) == ' ') {
                        continue;
                    } else {
                        stringBuilder.append(charSequence.charAt(j));
                        if ((stringBuilder.length() == 4 || stringBuilder.length() == 9)
                                && stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                            stringBuilder.insert(stringBuilder.length() - 1, ' ');
                        }
                    }
                }
                if (!stringBuilder.toString().equals(charSequence.toString())) {
                    int index = i + 1;
                    if (stringBuilder.charAt(i) == ' ') {
                        if (i1 == 0) {
                            index++;
                        } else {
                            index--;
                        }
                    } else {
                        if (i1 == 1) {
                            index--;
                        }
                    }
                    editText.setText(stringBuilder.toString());
                    editText.setSelection(index);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                button.setEnabled(length == 13);
                if(length > 13) editText.setError("Invalid number");
            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, CodeVerificationActivity.class);
        startActivity(intent);
    }
}