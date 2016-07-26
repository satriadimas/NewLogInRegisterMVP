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

import com.example.satriadimaspermana.loginregistermvp.Configure.LoginConfigure;
import com.example.satriadimaspermana.loginregistermvp.Interface.LoginInput;
import com.example.satriadimaspermana.loginregistermvp.Interface.LoginOutput;
import com.example.satriadimaspermana.loginregistermvp.MainActivity;
import com.example.satriadimaspermana.loginregistermvp.Model.LoginModel;
import com.example.satriadimaspermana.loginregistermvp.R;

public class Login extends AppCompatActivity implements LoginOutput {

    public LoginInput input;
    private EditText username;
    private EditText password;
    public static final String KEY="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginConfigure.getInstance().config(this);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

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

        password.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable d) {
                input.validasiHurufPass(password);
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
    public void displaySomething(LoginModel response) {
        Log.d("RESULT", "RESULT");
    }

    public void lakukanLogin(View view) {
        input.doLogin(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void displayLoginBerhasil(String hasil) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(KEY, hasil);
        startActivity(i);
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }


    public void lakukanRegister(View view) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
}
