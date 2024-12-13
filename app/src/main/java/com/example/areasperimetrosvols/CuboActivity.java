package com.example.areasperimetrosvols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CuboActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1;
    private Button btnResultado;
    private TextView txtResultadoVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        // Configuración de la barra de acción
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cubo");
        }

        // Inicialización de vistas
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtResultadoVolumen = findViewById(R.id.txtResultadoVolumen);

        // Configuración del listener
        btnResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnResultado) {
            calcularVolumen();
        }
    }

    private void calcularVolumen() {
        String input = txtN1.getText().toString().trim();

        // Validación de entrada
        if (input.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un valor.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double lado1 = Double.parseDouble(input);

            if (lado1 <= 0) {
                Toast.makeText(this, "El valor debe ser mayor a cero.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cálculo del volumen
            double resultadoVolumen = Math.pow(lado1, 3);
            resultadoVolumen = Math.round(resultadoVolumen * 100.0) / 100.0;

            // Mostrar el resultado
            txtResultadoVolumen.setText(String.format("%.2f cm³", resultadoVolumen));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show();
        }
    }
}
