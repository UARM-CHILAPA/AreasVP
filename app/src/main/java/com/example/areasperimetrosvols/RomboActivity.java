package com.example.areasperimetrosvols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RomboActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1; // Lado del rombo
    private Button btnResultado;
    private TextView txtResultadoPerimetro, txtResultadoArea;

    private double lado1 = 0;
    private double resultadoPerimetro = 0;
    private double resultadoArea = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);

        // Establecer título en la barra de acción
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Rombo");
        }

        // Inicialización de vistas
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtResultadoArea = findViewById(R.id.txtResultadoArea);
        txtResultadoPerimetro = findViewById(R.id.txtResultadoPerimetro);

        btnResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnResultado) {
            calcularAreaYPerimetro();
        }
    }

    private void calcularAreaYPerimetro() {
        String strLado1 = txtN1.getText().toString().trim();

        // Validación de entradas vacías
        if (strLado1.isEmpty()) {
            txtResultadoArea.setText("Por favor, ingresa el valor del lado.");
            txtResultadoPerimetro.setText("");
            return;
        }

        try {
            // Conversión de la entrada a tipo double
            lado1 = Double.parseDouble(strLado1);

            // Validación de valor positivo
            if (lado1 <= 0) {
                txtResultadoArea.setText("Por favor, ingresa un valor mayor a 0.");
                txtResultadoPerimetro.setText("");
                return;
            }

            // Cálculo del perímetro (4 * lado)
            resultadoPerimetro = lado1 * 4;

            // Aproximación del área (lado^2 para un ángulo de 90 grados, pero esto es solo una aproximación)
            resultadoArea = Math.pow(lado1, 2);

            // Redondeo a dos decimales
            resultadoPerimetro = Math.round(resultadoPerimetro * 100.0) / 100.0;
            resultadoArea = Math.round(resultadoArea * 100.0) / 100.0;

            // Mostrar resultados
            txtResultadoPerimetro.setText(String.format("%.2f cm", resultadoPerimetro));
            txtResultadoArea.setText(String.format("%.2f cm²", resultadoArea));
        } catch (NumberFormatException e) {
            txtResultadoArea.setText("Por favor, ingresa un valor numérico válido.");
            txtResultadoPerimetro.setText("");
        }
    }
}
