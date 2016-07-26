package com.example.satriadimaspermana.loginregistermvp.Interface;

import android.widget.EditText;

/**
 * Created by gits on VIP
 * Input For Request Processs
 */
public interface RegisterInput {
    void doSomething(String strA, String strB);
    void doRegister(String username, String password1, String password2, String email);
    boolean validasiHuruf(EditText username);
    boolean validasiHurufPass(EditText password);
    boolean validasiEmail(EditText email);
}
