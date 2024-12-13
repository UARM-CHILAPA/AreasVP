package com.example.areasperimetrosvols;

public class Datos
{
    private int idFigura;
    private int imagenId;
    private String nombre;

    public Datos() {}

    public Datos(int idFigura, int imagenId, String nombre)
    {
        this.idFigura = idFigura;
        this.imagenId = imagenId;
        this.nombre = nombre;
    }

    public  int getIdFigura() { return idFigura; }
    public  int getImagenId()
    {
        return imagenId;
    }
    public String getNombre()
    {
        return nombre;
    }
}


