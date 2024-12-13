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

public class CirculoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1;
    private Button btnResultado;
    private TextView txtResultadoPerimetro;
    private TextView txtResultadoArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        // Verificar que el ActionBar no sea nulo antes de cambiar el título
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Círculo");
        }

        // Inicializar elementos de la interfaz
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtResultadoArea = findViewById(R.id.txtResultadoArea);
        txtResultadoPerimetro = findViewById(R.id.txtResultadoPerimetro);

        btnResultado.setOnClickListener(this); // Asignar listener al botón
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnResultado) {
            calcularPerimetroYArea();
        }
    }

    private void calcularPerimetroYArea() {
        String strRadio = txtN1.getText().toString().trim();

        if (strRadio.isEmpty()) {
            txtResultadoArea.setText("Por favor, ingresa el valor del radio.");
            txtResultadoPerimetro.setText("");
            return;
        }

        try {
            double radio = Double.parseDouble(strRadio);

            // Cálculo del perímetro y área
            double perimetro = 2 * Math.PI * radio;
            double area = Math.PI * Math.pow(radio, 2);

            // Redondeo de resultados a dos decimales
            perimetro = Math.round(perimetro * 100.0) / 100.0;
            area = Math.round(area * 100.0) / 100.0;

            // Mostrar resultados
            txtResultadoArea.setText(area + " cm²");
            txtResultadoPerimetro.setText(perimetro + " cm");

        } catch (NumberFormatException e) {
            txtResultadoArea.setText("Valor no válido. Ingresa un número.");
            txtResultadoPerimetro.setText("");
        }
    }
}