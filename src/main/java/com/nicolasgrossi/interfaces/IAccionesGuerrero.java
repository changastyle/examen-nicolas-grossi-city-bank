package com.nicolasgrossi.interfaces;

import com.nicolasgrossi.modelo.MovimientoJugador;
import com.nicolasgrossi.modelo.Guerrero;

public interface IAccionesGuerrero
{
    public final static char derecha = 'r';
    public final static char izquierda = 'l';
    public final static char arriba = 'u';
    public final static char abajo = 'd';
    
    public double atacar(Guerrero enemigo);
    public MovimientoJugador avanzar(Guerrero guererro, char direccion, boolean verbose);
}
