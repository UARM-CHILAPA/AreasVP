package com.example.areasperimetrosvols;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AreasActivity extends AppCompatActivity {

    private ArrayList<Datos> listDatos;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Áreas y Perímetros");
        } else {
            Log.e("AreasActivity", "No se encontró ActionBar");
        }


        recycler = findViewById(R.id.recyclerIdAreas);

        recycler.setHasFixedSize(true);
        Configuration orientation = new Configuration();

        if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recycler.setLayoutManager(new GridLayoutManager(this,1));
        }
        else if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recycler.setLayoutManager(new GridLayoutManager(this,2));
        };

        listDatos = new ArrayList<Datos>();

        listDatos.add(new Datos(1,R.drawable.triangulo,"Triángulo"));
        listDatos.add(new Datos(2,R.drawable.rectangulo,"Rectángulo"));
        listDatos.add(new Datos(3,R.drawable.rombo,"Rombo"));
        listDatos.add(new Datos(4, R.drawable.circulo,"Círculo"));
        listDatos.add(new Datos(5, R.drawable.hept_gono,"Hexágono"));

        AdapterDatos adapter = new AdapterDatos(listDatos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent();
                if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 1){
                    b = new Intent(AreasActivity.this, TrianguloActivity.class);
                } else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 2){
                    b = new Intent(AreasActivity.this, RectanguloActivity.class);
                }else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 3){
                    b = new Intent(AreasActivity.this, RomboActivity.class);
                }else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 4){
                    b = new Intent(AreasActivity.this, CirculoActivity.class);
                }else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 5){
                    b = new Intent(AreasActivity.this, HexagonoActivity.class);
                };

                startActivity(b);
            }
        });

        recycler.setAdapter(adapter);
    }
}