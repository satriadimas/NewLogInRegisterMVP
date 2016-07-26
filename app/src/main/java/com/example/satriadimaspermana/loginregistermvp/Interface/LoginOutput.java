package com.example.satriadimaspermana.loginregistermvp.Interface;

import com.example.satriadimaspermana.loginregistermvp.Model.LoginModel;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface LoginOutput {
    void displaySomething(LoginModel response);
    void displayLoginBerhasil(String hasil);
    void displayError(String error);
}