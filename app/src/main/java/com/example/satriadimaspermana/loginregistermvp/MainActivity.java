package com.example.satriadimaspermana.loginregistermvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.satriadimaspermana.loginregistermvp.View.Login;
import com.example.satriadimaspermana.loginregistermvp.View.Register;

public class MainActivity extends AppCompatActivity {

    private TextView keluaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keluaran = (TextView) findViewById(R.id.keluaran);

        Bundle b  =  getIntent().getExtras();
        if (b.getString(Login.KEY) != null) {
            String hasil = getIntent().getStringExtra(Login.KEY);
            keluaran.setText(hasil);
        }else{
            String hasil = getIntent().getStringExtra(Register.REY);
            keluaran.setText(hasil);
        }

    }
}
