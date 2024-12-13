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

public class ConoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtN1;
    private EditText txtN2;
    private Button btnResultado;
    private TextView txtResultadoVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        // Verificar si el ActionBar no es nulo antes de cambiar el título
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cono");
        }

        // Inicialización de los elementos de la interfaz
        btnResultado = findViewById(R.id.btnResultado);
        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
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
        String strRadio = txtN1.getText().toString().trim();
        String strAltura = txtN2.getText().toString().trim();

        if (strRadio.isEmpty() || strAltura.isEmpty()) {
            txtResultadoVolumen.setText("Por favor, completa ambos campos.");
            return;
        }

        try {
            double radio = Double.parseDouble(strRadio);
            double altura = Double.parseDouble(strAltura);

            // Cálculo del volumen del cono
            double volumen = (Math.PI * Math.pow(radio, 2) * altura) / 3;
            volumen = Math.round(volumen * 100.0) / 100.0;

            // Mostrar el resultado
            txtResultadoVolumen.setText(volumen + " cm³");
        } catch (NumberFormatException e) {
            txtResultadoVolumen.setText("Por favor, ingresa valores numéricos válidos.");
        }
    }
}