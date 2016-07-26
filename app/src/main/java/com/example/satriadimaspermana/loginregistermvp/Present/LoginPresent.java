package com.example.satriadimaspermana.loginregistermvp.Present;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.satriadimaspermana.loginregistermvp.Interface.LoginInput;
import com.example.satriadimaspermana.loginregistermvp.Interface.LoginOutput;
import com.example.satriadimaspermana.loginregistermvp.Model.LoginModel;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class LoginPresent implements LoginInput {
    public LoginOutput output;
    private boolean kondisi;
    private String hasil;

    @Override
    public void doSomething(String strA, String strB) {
        LoginModel response = new LoginModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void doLogin(String username, String password) {
        kondisi = false;
        if(username.equals("admin") && password.equals("admin")){
            hasil= "Selamat kamu berhasil login menggunakan username " + username;
            output.displayLoginBerhasil(hasil);
        } else{
            output.displayError("Gagal Login");
        }
    }

    @Override
    public boolean validasiHuruf(final EditText username) {
        String text = username.getText().toString().trim();
        username.setError(null);

        // length 0 means there is no text
        if (text.length() < 5) {
            username.setError(Html.fromHtml("<font color='red'>Karakter minimal 5</font>"));
            return false;
        }
        return true;
    }

    @Override
    public boolean validasiHurufPass(EditText password) {
        String textPass = password.getText().toString().trim();
        password.setError(null);

        // length 0 means there is no text
        if (textPass.length() < 8) {
            password.setError(Html.fromHtml("<font color='red'>Karakter minimal 8</font>"));
            return false;
        }
        return true;
    }


}