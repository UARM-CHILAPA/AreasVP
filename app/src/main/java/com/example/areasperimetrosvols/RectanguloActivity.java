package com.example.areasperimetrosvols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RectanguloActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1, txtN2;
    private Button btnResultado;
    private TextView txtResultadoPerimetro, txtResultadoArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        // Establecer título en la barra de acción
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Rectángulo");
        }

        // Inicialización de vistas
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
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
        String strLado2 = txtN2.getText().toString().trim();

        // Validación de entradas vacías
        if (strLado1.isEmpty() || strLado2.isEmpty()) {
            txtResultadoArea.setText("Por favor, ingresa todos los valores.");
            txtResultadoPerimetro.setText("");
            return;
        }

        try {
            // Conversión de las entradas a tipo double
            double lado1 = Double.parseDouble(strLado1);
            double lado2 = Double.parseDouble(strLado2);

            // Cálculo del perímetro y del área
            double perimetro = 2 * (lado1 + lado2);
            double area = lado1 * lado2;

            // Redondeo a dos decimales
            perimetro = Math.round(perimetro * 100.0) / 100.0;
            area = Math.round(area * 100.0) / 100.0;

            // Mostrar resultados
            txtResultadoPerimetro.setText(perimetro + " cm");
            txtResultadoArea.setText(area + " cm²");
        } catch (NumberFormatException e) {
            txtResultadoArea.setText("Por favor, ingresa valores numéricos válidos.");
            txtResultadoPerimetro.setText("");
        }
    }
}