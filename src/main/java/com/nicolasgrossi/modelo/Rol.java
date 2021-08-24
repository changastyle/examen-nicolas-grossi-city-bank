package com.nicolasgrossi.modelo;

public class Rol
{
    private int id;
    private String vocacion;
    private double att;
    private double def;
    private double vel;

    public Rol()
    {
    }

    public Rol(int id, String vocacion, double att, double def, double vel)
    {
        this.id = id;
        this.vocacion = vocacion;
        this.att = att;
        this.def = def;
        this.vel = vel;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getVocacion()
    {
        return vocacion;
    }

    public void setVocacion(String vocacion)
    {
        this.vocacion = vocacion;
    }

    public double getAtt()
    {
        return att;
    }

    public void setAtt(double att)
    {
        this.att = att;
    }

    public double getDef()
    {
        return def;
    }

    public void setDef(double def)
    {
        this.def = def;
    }

    public double getVel()
    {
        return vel;
    }

    public void setVel(double vel)
    {
        this.vel = vel;
    }

    @Override
    public String toString()
    {
        return "Rol{" + "id=" + id + ", vocacion=" + vocacion + '}';
    }
    
    
}
