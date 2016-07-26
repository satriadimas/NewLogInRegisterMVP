package com.example.satriadimaspermana.loginregistermvp.Configure;

import com.example.satriadimaspermana.loginregistermvp.View.Login;
import com.example.satriadimaspermana.loginregistermvp.Present.LoginPresent;

/**
 * Created by gits on Configurator
 */
public class LoginConfigure {
    private static LoginConfigure ourInstance = new LoginConfigure();

    private LoginConfigure() {
    }

    public static LoginConfigure getInstance() {
        return ourInstance;
    }

    public void config(Login activity) {
        LoginPresent present = new LoginPresent();
        present.output = activity;
        activity.input = present;
    }
}
