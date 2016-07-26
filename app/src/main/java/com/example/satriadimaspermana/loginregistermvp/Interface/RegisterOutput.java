package com.example.satriadimaspermana.loginregistermvp.Interface;

import com.example.satriadimaspermana.loginregistermvp.Model.RegisterModel;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface RegisterOutput {
    void displaySomething(RegisterModel response);
    void displayRegisterBerhasil(String hasilRegister);
    void displayError(String error);
}