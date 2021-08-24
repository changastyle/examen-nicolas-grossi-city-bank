package com.nicolasgrossi.modelo;

import com.nicolasgrossi.MasterController;
import java.io.Serializable;

public class MovimientoJugador implements Serializable
{
    private int x;
    private int y;
    private double tiempoDelay;


    public MovimientoJugador(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.tiempoDelay = 1;
    }

    
    
    
    //<editor-fold desc="GYS:">
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public double getTiempoDelay()
    {
        return tiempoDelay;
    }

    public void setTiempoDelay(double tiempoDelay)
    {
        this.tiempoDelay = tiempoDelay;
    }
    
    //</editor-fold>

    @Override
    public String toString()
    {
        return "POS(" + x + "," + y +")";
    }
}
