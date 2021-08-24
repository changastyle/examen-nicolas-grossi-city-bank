package com.nicolasgrossi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ejercito
{
    private String nombre;
    private String color;
    private List<Guerrero> arrGuerreros;

    public Ejercito()
    {
    }

    public Ejercito(String nombre, String color)
    {
        this.nombre = nombre;
        this.color = color;
        this.arrGuerreros = new ArrayList<>();
    }

    

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public List<Guerrero> getArrGuerreros()
    {
        return arrGuerreros;
    }

    public void setArrGuerreros(List<Guerrero> arrGuerreros)
    {
        this.arrGuerreros = arrGuerreros;
    }
    
    public void addGuerrero(Guerrero guerrero)
    {
        if(arrGuerreros == null)
        {
            arrGuerreros = new ArrayList<>();
        }
       
        arrGuerreros.add(guerrero);
        
    }
    
    
}
