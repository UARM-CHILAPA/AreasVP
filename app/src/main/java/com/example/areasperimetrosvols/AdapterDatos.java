package com.example.areasperimetrosvols;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener
{

    ArrayList<Datos> listDatos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<Datos> listDatos){ this.listDatos = listDatos;}

    @Override public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    };

    @Override public void onBindViewHolder(ViewHolderDatos holder, int position)
    {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override public int getItemCount(){return listDatos.size();}

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        private TextView nombre;
        private ImageView img;

        public ViewHolderDatos(View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.imgView);
            nombre = itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(Datos datos){
            nombre.setText(datos.getNombre());
            img.setImageResource(datos.getImagenId());
        }
    }
}
