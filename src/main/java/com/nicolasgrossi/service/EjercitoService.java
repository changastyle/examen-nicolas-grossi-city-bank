package com.nicolasgrossi.service;

import com.nicolasgrossi.MasterController;
import com.nicolasgrossi.interfaces.*;
import com.nicolasgrossi.modelo.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository @ComponentScan
public class EjercitoService implements IEjercitoService
{
    @Autowired RolService rolService;
    @Autowired GuerreroService guerreroService;
    
    public Ejercito crearEjercitoFast(int cantidadSoldados , int cantCaballosSolicitados , String nombre , String color)
    {
        int randomMAXSoldados = cantidadSoldados;
        int contadorCantCaballos = 0 ;
        
        System.out.println("| ----------- EJERCITO " + nombre +" (" + randomMAXSoldados + ") -------------|");
        
        Ejercito ejercito = new Ejercito(nombre, color);
        
        for(int i = 0 ; i < randomMAXSoldados; i ++)
        {
            // REVISO QUE TENGA LA CANTIDAD DE CABALLOS ASOCIADAS:
            boolean tienecaballo = false;
            
            if(contadorCantCaballos < cantCaballosSolicitados)
            {
                tienecaballo = true;
            }
            
            Guerrero guerreroRandom = guerreroService.crearGuerreroFast(tienecaballo);
            
            if(guerreroRandom != null)
            {
                ejercito.addGuerrero(guerreroRandom);
                System.out.println("" + guerreroRandom);
            }
        }
        
        return ejercito;
    }
    
    public ReporteEjercito reciboColeccionYCalculoTotalesPunto1(List<Guerrero> arrGuerreros , String vocacionParam)
    {
        ReporteEjercito reporteRta = new ReporteEjercito();
        List<Guerrero> arrGuerrerosFiltradosByVocacion = null;
        
        if(arrGuerreros != null)
        {
            
            // SI TENGO UNA VOCACION FILTRO POR VOCACION:
            if(vocacionParam!= null && vocacionParam.length() > 0)
            {
                arrGuerrerosFiltradosByVocacion = arrGuerreros.stream().filter(g -> g.getRol().getVocacion().equalsIgnoreCase(vocacionParam)).collect(Collectors.toList());   
            }
            else
            {
                // DE LO CONTRARIO USO LA COLECCION TOTAL:
                arrGuerrerosFiltradosByVocacion = arrGuerreros;
            }
            
            reporteRta.setArrGuerreros(arrGuerrerosFiltradosByVocacion);
            
            // 1 - "FUNCIONES STREAM - LAMBDA" - LA COMPLEJIDAD ES BAJA , NO CONVIENE USAR PARALLEL STREAM:;
            double sumatoriaAttEjercito = arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularPtosAtt).sum();
            double sumatoriaDefEjercito = arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularPtosDefensa).sum();
            double sumatoriaPromedioVelEjercito = (double)arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularVelocidad).average().getAsDouble();

            // 2 - POPULO EL OBJETO REPORTE PARA ENVIAR AL FRONTEND:
            reporteRta.setAttTotal(sumatoriaAttEjercito);
            reporteRta.setDefTotal(sumatoriaDefEjercito);
            reporteRta.setVelocidadPromedio(sumatoriaPromedioVelEjercito);
        }
        
        return reporteRta;
    }
    public ReporteEjercito reciboColeccionYCalculoTotalesPunto3(List<Guerrero> arrGuerreros , String vocacionParam)
    {
        double sumatoriaAttEjercito = 0;
        double sumatoriaDefEjercito = 0;
        double sumatoriaPromedioVelEjercito = 0;
        
        ReporteEjercito reporteRta = new ReporteEjercito();
        if(arrGuerreros != null && vocacionParam != null)
        {
            System.out.println("VOCACIONN::" + vocacionParam);
            reporteRta.setArrGuerreros(arrGuerreros);
            
            // 1 - "FUNCIONES STREAM - LAMBDA" - LA COMPLEJIDAD ES BAJA , NO CONVIENE USAR PARALLEL STREAM:;
//            List<Guerrero> arrGuerrerosFiltradosByVocacion = MasterController.filtrarPorRol(arrGuerreros,vocacionParam);
            List<Guerrero> arrGuerrerosFiltradosByVocacion = arrGuerreros.stream().filter(g -> g.getCalcularNombreRol2().equalsIgnoreCase(vocacionParam)).collect(Collectors.toList());   
            if(arrGuerrerosFiltradosByVocacion != null)
            {
                sumatoriaAttEjercito = arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularPtosAtt).sum();
                sumatoriaDefEjercito = arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularPtosDefensa).sum();
                sumatoriaPromedioVelEjercito = arrGuerrerosFiltradosByVocacion.stream().mapToDouble(Guerrero::calcularVelocidad).sum();
            }

            // 2 - POPULO EL OBJETO REPORTE PARA ENVIAR AL FRONTEND:
            reporteRta.setAttTotal(sumatoriaAttEjercito);
            reporteRta.setDefTotal(sumatoriaDefEjercito);
            reporteRta.setVelocidadPromedio(sumatoriaPromedioVelEjercito);
        }
        
        return reporteRta;
    }
    
    
    
}
