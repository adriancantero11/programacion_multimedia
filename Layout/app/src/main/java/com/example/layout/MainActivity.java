package com.example.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtPantalla;

    Button btn0, btn1, btn2, btn3, btn4;
    Button btn5, btn6, btn7, btn8, btn9;

    Button btnSum, btnRes, btnMul, btnDiv;
    Button btnPunto, btnIgual, btnC, btnAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calculadora);

        txtPantalla = findViewById(R.id.txtPantalla);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnSum = findViewById(R.id.btnSum);
        btnRes = findViewById(R.id.btnRes);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnPunto = findViewById(R.id.btnPunto);
        btnIgual = findViewById(R.id.btnIgual);

        btnC = findViewById(R.id.btnC);
        btnAC = findViewById(R.id.btnAC);

        // NÚMEROS
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir("9");
            }
        });

        // OPERACIONES (agrega el símbolo directamente al texto en pantalla)
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribirOperador("+");
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribirOperador("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribirOperador("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribirOperador("/");
            }
        });

        // PUNTO DECIMAL
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribir(".");
            }
        });

        // AC (Limpiar pantalla)
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPantalla.setText("0");
            }
        });

        // C (Borrar el último carácter introducido)
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = txtPantalla.getText().toString();
                if (texto.length() > 1) {
                    txtPantalla.setText(texto.substring(0, texto.length() - 1));
                } else {
                    txtPantalla.setText("0");
                }
            }
        });

        // IGUAL (Lee la expresión tipo "8+8", separa los números y opera)
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expresion = txtPantalla.getText().toString();

                // Buscamos cuál operador (+, -, *, /) contiene la pantalla
                String operador = "";
                if (expresion.contains("+")) {
                    operador = "+";
                } else if (expresion.contains("-")) {
                    operador = "-";
                } else if (expresion.contains("*")) {
                    operador = "*";
                } else if (expresion.contains("/")) {
                    operador = "/";
                }

                // Si no hay operador escrito o la cadena es incompleta, no hacemos nada
                if (operador.isEmpty()) {
                    return;
                }

                // Usamos split con "\\" porque en Expresiones Regulares el '+' y '*' son caracteres especiales
                String[] partes = expresion.split("\\" + operador);

                if (partes.length == 2) {
                    try {
                        double num1 = Double.parseDouble(partes[0]);
                        double num2 = Double.parseDouble(partes[1]);
                        double resultado = 0;

                        if (operador.equals("+")) {
                            resultado = num1 + num2;
                        } else if (operador.equals("-")) {
                            resultado = num1 - num2;
                        } else if (operador.equals("*")) {
                            resultado = num1 * num2;
                        } else if (operador.equals("/")) {
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                txtPantalla.setText("Error");
                                return;
                            }
                        }

                        // Muestra el resultado de forma limpia (sin .0 si es entero)
                        if (resultado % 1 == 0) {
                            txtPantalla.setText(String.valueOf((long) resultado));
                        } else {
                            txtPantalla.setText(String.valueOf(resultado));
                        }

                    } catch (NumberFormatException e) {
                        txtPantalla.setText("Error");
                    }
                }
            }
        });
    }

    private void escribir(String valor) {
        String texto = txtPantalla.getText().toString();

        if (texto.equals("0")) {
            if (!valor.equals("0")) {
                txtPantalla.setText(valor);
            }
        } else {
            txtPantalla.setText(texto + valor);
        }
    }

    private void escribirOperador(String op) {
        String texto = txtPantalla.getText().toString();

        // Evita poner un operador al principio o poner dos operadores seguidos
        if (!texto.endsWith("+") && !texto.endsWith("-") &&
                !texto.endsWith("*") && !texto.endsWith("/") &&
                !texto.contains("+") && !texto.contains("-") &&
                !texto.contains("*") && !texto.contains("/")) {

            txtPantalla.setText(texto + op);
        }
    }
}