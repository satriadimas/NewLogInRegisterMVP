package com.example.satriadimaspermana.loginregistermvp.Interface;

import android.widget.EditText;

/**
 * Created by gits on VIP
 * Input For Request Processs
 */
public interface LoginInput {
    void doSomething(String strA, String strB);
    void doLogin(String username, String password);
    boolean validasiHuruf(EditText username);
    boolean validasiHurufPass(EditText password);
}
