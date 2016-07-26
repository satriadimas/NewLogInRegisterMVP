package com.example.satriadimaspermana.loginregistermvp.Present;

import android.text.Html;
import android.widget.EditText;

import com.example.satriadimaspermana.loginregistermvp.Interface.RegisterInput;
import com.example.satriadimaspermana.loginregistermvp.Interface.RegisterOutput;
import com.example.satriadimaspermana.loginregistermvp.Model.RegisterModel;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class RegisterPresent implements RegisterInput {
    public RegisterOutput output;
    private boolean kondisi;
    private String hasil;

    @Override
    public void doSomething(String strA, String strB) {
        RegisterModel response = new RegisterModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void doRegister(String username, String password1, String password2, String email) {
        kondisi = false;
        if (password1.equals(password2)){
            hasil= "Selamat kamu berhasil Register menggunakan username " + username;
            output.displayRegisterBerhasil(hasil);
        }else{
            output.displayError("Password Tidak Sama");
        }
    }

    @Override
    public boolean validasiHuruf(EditText username) {

        String txtUsername = username.getText().toString().trim();
        username.setError(null);

        // length 0 means there is no text
        if (txtUsername.length() < 5) {
            username.setError(Html.fromHtml("<font color='red'>Karakter minimal 5</font>"));
            return false;
        }

        return true;
    }

    @Override
    public boolean validasiHurufPass(EditText password) {
        String txtPass = password.getText().toString().trim();
        password.setError(null);

        // length 0 means there is no text
        if (txtPass.length() < 8) {
            password.setError(Html.fromHtml("<font color='red'>Karakter minimal 8</font>"));
            return false;
        }

        return true;
    }

    @Override
    public boolean validasiEmail(EditText email) {
        String txtEmail = email.getText().toString().trim();
        email.setError(null);
        if (!txtEmail.contains("@") && !txtEmail.contains(".")) {
            email.setError(Html.fromHtml("<font color='red'>Email tidak cocok</font>"));
        }

        return true;
    }

}