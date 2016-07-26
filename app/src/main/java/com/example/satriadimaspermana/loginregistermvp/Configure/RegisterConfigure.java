package com.example.satriadimaspermana.loginregistermvp.Configure;

import com.example.satriadimaspermana.loginregistermvp.View.Register;
import com.example.satriadimaspermana.loginregistermvp.Present.RegisterPresent;

/**
 * Created by gits on Configurator
 */
public class RegisterConfigure {
    private static RegisterConfigure ourInstance = new RegisterConfigure();

    private RegisterConfigure() {
    }

    public static RegisterConfigure getInstance() {
        return ourInstance;
    }

    public void config(Register activity) {
        RegisterPresent present = new RegisterPresent();
        present.output = activity;
        activity.input = present;
    }
}
