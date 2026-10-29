package com.example.tema4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView miTexto = (TextView) findViewById(R.id.texto);

        miTexto.setText("Nuevo texto a mostrar");

        // Opción 1: color personalizado
        miTexto.setTextColor(Color.parseColor("#0000FF"));

        // Opción 2: color predefinido
        // miTexto.setTextColor(Color.RED);

        // Texto en cursiva
        miTexto.setTypeface(null, Typeface.ITALIC);

        // Tamaño del texto
        miTexto.setTextSize(24);

        // Tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);
    }
}