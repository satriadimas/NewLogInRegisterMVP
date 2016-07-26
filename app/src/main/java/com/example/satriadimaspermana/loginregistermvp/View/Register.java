package com.example.satriadimaspermana.loginregistermvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.satriadimaspermana.loginregistermvp.Configure.RegisterConfigure;
import com.example.satriadimaspermana.loginregistermvp.Interface.RegisterInput;
import com.example.satriadimaspermana.loginregistermvp.Interface.RegisterOutput;
import com.example.satriadimaspermana.loginregistermvp.MainActivity;
import com.example.satriadimaspermana.loginregistermvp.Model.RegisterModel;
import com.example.satriadimaspermana.loginregistermvp.R;

public class Register extends AppCompatActivity implements RegisterOutput {

    public RegisterInput input;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private EditText email;
    public static final String REY="REGISTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterConfigure.getInstance().config(this);

        username = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        email = (EditText) findViewById(R.id.email);

        username.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                input.validasiHuruf(username);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

        password1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable d) {
                input.validasiHurufPass(password1);
            }

            public void beforeTextChanged(CharSequence d, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence d, int start, int before,int count) {
            }
        });

        password2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable d) {
                input.validasiHurufPass(password2);
            }

            public void beforeTextChanged(CharSequence d, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence d, int start, int before,int count) {
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable d) {
                input.validasiEmail(email);
            }

            public void beforeTextChanged(CharSequence d, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence d, int start, int before,int count) {
            }
        });

        doSomething();
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(RegisterModel response) {
        Log.d("RESULT", "RESULT");
    }

    public void onRegister(View view) {
        input.doRegister(username.getText().toString(), password1.getText().toString(),password2.getText().toString(), email.getText().toString().trim());
    }

    @Override
    public void displayRegisterBerhasil(String hasilRegister) {
        Intent i = new Intent(Register.this, MainActivity.class);
        i.putExtra(REY, hasilRegister);
        startActivity(i);
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}
