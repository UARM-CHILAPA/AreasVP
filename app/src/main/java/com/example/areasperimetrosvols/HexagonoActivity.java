package com.example.areasperimetrosvols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class HexagonoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1;
    private Button btnResultado;
    private TextView txtResultadoPerimetro;
    private TextView txtResultadoArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexagono);

        // Cambiar título a "Hexágono"
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Hexágono");
        }

        // Inicialización de los elementos de la interfaz
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtResultadoArea = findViewById(R.id.txtResultadoArea);
        txtResultadoPerimetro = findViewById(R.id.txtResultadoPerimetro);

        btnResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnResultado) {
            calcularPerimetroYArea();
        }
    }

    private void calcularPerimetroYArea() {
        String strLado = txtN1.getText().toString().trim();

        if (strLado.isEmpty()) {
            txtResultadoArea.setText("Por favor, ingresa el valor del lado.");
            txtResultadoPerimetro.setText("");
            return;
        }

        try {
            double lado = Double.parseDouble(strLado);

            // Cálculo del perímetro (P = 6 * lado)
            double perimetro = lado * 6;

            // Cálculo del área (A = (3 * √3 * lado²) / 2)
            double area = (3 * Math.sqrt(3) * Math.pow(lado, 2)) / 2;

            // Redondeo a dos decimales
            perimetro = Math.round(perimetro * 100.0) / 100.0;
            area = Math.round(area * 100.0) / 100.0;

            // Mostrar los resultados
            txtResultadoPerimetro.setText(perimetro + " cm");
            txtResultadoArea.setText(area + " cm²");
        } catch (NumberFormatException e) {
            txtResultadoArea.setText("Por favor, ingresa un valor numérico válido.");
            txtResultadoPerimetro.setText("");
        }
    }
}