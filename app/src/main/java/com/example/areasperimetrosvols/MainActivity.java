package com.example.areasperimetrosvols;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
public class MainActivity extends AppCompatActivity {

    private CardView cardAreas;
    private CardView cardVolumenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardAreas = findViewById(R.id.idCardAreas);
        cardVolumenes = findViewById(R.id.idCardVolumenes);

        cardAreas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, AreasActivity.class);
                startActivity(a);
            }
        });

        cardVolumenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this, VolumenesActivity.class);
                startActivity(b);
            }
        });
    }
}