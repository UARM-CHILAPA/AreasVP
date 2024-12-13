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

public class ParalelepipedoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1, txtN2, txtN3;
    private Button btnResultado;
    private TextView txtResultadoVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paralelepipedo);

        // Establece el título en el ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Paralelepípedo");
        }

        // Inicialización de vistas
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
        txtN3 = findViewById(R.id.txtN3);
        txtResultadoVolumen = findViewById(R.id.txtResultadoVolumen);

        btnResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnResultado) {
            calcularVolumen();
        }
    }

    private void calcularVolumen() {
        String strLado1 = txtN1.getText().toString().trim();
        String strLado2 = txtN2.getText().toString().trim();
        String strLado3 = txtN3.getText().toString().trim();

        // Validación de entradas vacías
        if (strLado1.isEmpty() || strLado2.isEmpty() || strLado3.isEmpty()) {
            txtResultadoVolumen.setText("Por favor, ingresa todos los valores.");
            return;
        }

        try {
            // Conversión de cadenas a números
            double lado1 = Double.parseDouble(strLado1);
            double lado2 = Double.parseDouble(strLado2);
            double lado3 = Double.parseDouble(strLado3);

            // Cálculo del volumen del paralelepípedo
            double volumen = lado1 * lado2 * lado3;

            // Redondeo del volumen a dos decimales
            volumen = Math.round(volumen * 100.0) / 100.0;

            // Mostrar resultado
            txtResultadoVolumen.setText(volumen + " cm³");
        } catch (NumberFormatException e) {
            txtResultadoVolumen.setText("Por favor, ingresa valores numéricos válidos.");
        }
    }
}