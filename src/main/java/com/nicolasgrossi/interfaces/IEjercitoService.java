package com.nicolasgrossi.interfaces;

import com.nicolasgrossi.modelo.Ejercito;
import com.nicolasgrossi.modelo.Guerrero;
import com.nicolasgrossi.modelo.ReporteEjercito;
import java.util.List;
import java.util.stream.Collectors;

public interface IEjercitoService
{
    public Ejercito crearEjercitoFast(int cantidadSoldados , int cantCaballosSolicitados , String nombre , String color);
    public ReporteEjercito reciboColeccionYCalculoTotalesPunto1(List<Guerrero> arrGuerreros , String vocacionParam);
    public ReporteEjercito reciboColeccionYCalculoTotalesPunto3(List<Guerrero> arrGuerreros , String vocacionParam);
}
