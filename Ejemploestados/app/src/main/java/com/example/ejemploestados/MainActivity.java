package com.example.ejemploestados;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Ejemplo", "Estoy en onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ejemplo", "Estoy en onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ejemplo", "Estoy en onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ejemplo", "Estoy en onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ejemplo", "Estoy en onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ejemplo", "Estoy en onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Ejemplo", "Estoy en onDestroy");

        Intent ejemplo= new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
    }
}