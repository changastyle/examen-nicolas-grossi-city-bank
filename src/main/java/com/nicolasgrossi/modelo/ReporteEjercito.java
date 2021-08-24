package com.nicolasgrossi.modelo;

import java.io.Serializable;
import java.util.List;

public class ReporteEjercito implements Serializable
{
    private double attTotal;
    private double defTotal;
    private double velocidadPromedio;
    private List<Guerrero> arrGuerreros;

    public ReporteEjercito()
    {
    }

    
    public List<Guerrero> getArrGuerreros()
    {
        return arrGuerreros;
    }

    public void setArrGuerreros(List<Guerrero> arrGuerreros)
    {
        this.arrGuerreros = arrGuerreros;
    }

    public double getAttTotal()
    {
        return attTotal;
    }

    public void setAttTotal(double attTotal)
    {
        this.attTotal = attTotal;
    }

    public double getDefTotal()
    {
        return defTotal;
    }

    public void setDefTotal(double defTotal)
    {
        this.defTotal = defTotal;
    }

    public double getVelocidadPromedio()
    {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio)
    {
        this.velocidadPromedio = velocidadPromedio;
    }

    
    
    
    
    
}
