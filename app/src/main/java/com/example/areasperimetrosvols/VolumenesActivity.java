package com.example.areasperimetrosvols;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VolumenesActivity extends AppCompatActivity {

    private ArrayList<Datos> listDatos;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        recycler = findViewById(R.id.recyclerIdVolumenes);

        recycler.setHasFixedSize(true);
        Configuration orientation = new Configuration();

        if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recycler.setLayoutManager(new GridLayoutManager(this,1));
        }
        else if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recycler.setLayoutManager(new GridLayoutManager(this,2));
        };

        listDatos = new ArrayList<Datos>();

        listDatos.add(new Datos(1,R.drawable.cubo,"Cubo"));
        listDatos.add(new Datos(2,R.drawable.trapecio,"Trapecio"));
        listDatos.add(new Datos(3,R.drawable.cilindro,"Cilindro"));
        listDatos.add(new Datos(4,R.drawable.esfera,"Esfera"));
        listDatos.add(new Datos(5,R.drawable.cono,"Cono"));

        AdapterDatos adapter = new AdapterDatos(listDatos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent();
                if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 1){
                    b = new Intent(VolumenesActivity.this, CuboActivity.class);
                } else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 2){
                    b = new Intent(VolumenesActivity.this, ParalelepipedoActivity.class);
                }
                else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 3){
                    b = new Intent(VolumenesActivity.this, CilindroActivity.class);
                }
                else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 4){
                    b = new Intent(VolumenesActivity.this, EsferaActivity.class);
                }
                else if(listDatos.get(recycler.getChildAdapterPosition(view)).getIdFigura() == 5){
                    b = new Intent(VolumenesActivity.this, ConoActivity.class);
                };

                startActivity(b);
            }
        });

        recycler.setAdapter(adapter);
    }
}