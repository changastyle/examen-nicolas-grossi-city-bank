package com.nicolasgrossi.ws;

import com.nicolasgrossi.MasterController;
import com.nicolasgrossi.modelo.Ejercito;
import com.nicolasgrossi.modelo.Guerrero;
import com.nicolasgrossi.modelo.ReporteEjercito;
import com.nicolasgrossi.service.EjercitoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "ejercito")
public class wsEjercito
{
    @Autowired EjercitoService ejercitoService;
    
    @RequestMapping(value = "crear")
    public Ejercito crear
    (
        @RequestParam(value = "cantSoldados" , required=false , defaultValue ="10") int cantSoldados,
        @RequestParam(value = "cantCaballos" , required=false , defaultValue = "0") int cantCaballos  
    )
    {
        Ejercito ejercito = ejercitoService.crearEjercitoFast(cantSoldados , cantCaballos , "ROJO2", "#F00");
        
        return ejercito;
    }
    @RequestMapping(value = "reciboColeccionYCalculoTotalesPunto1")
    public ReporteEjercito reciboColeccionYCalculoTotalesPunto1
    (
        @RequestParam(value = "cantSoldados" , required=false , defaultValue = "10") int cantSoldados,
        @RequestParam(value = "cantCaballos" , required=false , defaultValue = "0") int cantCaballos 
    )
    {
        // 1 - REPORTE:
        ReporteEjercito reporteRta = new ReporteEjercito();

        // 2 - CREO UN EJERCITO RAPIDAMENTE:
        Ejercito ejercito = ejercitoService.crearEjercitoFast( cantSoldados , cantCaballos , "ROJO2", "#F00");
        
        // 3 - ENVIO EL LISTADO DE GUERREROS COMO PIDE EL PUNTO 1 AL SERVICE QUE PROCESA LAS COSAS CON FUNCIONES LAMDA:
        List<Guerrero> arrGuerreros = ejercito.getArrGuerreros();
        reporteRta = ejercitoService.reciboColeccionYCalculoTotalesPunto1(arrGuerreros, null);
        
        return reporteRta;
    }
    
    @RequestMapping(value = "generoEjercitoRapidoyReciboCantCaballos/{cantSoldados}/{cantCaballos}")
    public ReporteEjercito generoEjercitoRapidoyReciboCantCaballos
    (
        @PathVariable(value = "cantSoldados" , required=true) int  cantSoldados,   
        @PathVariable(value = "cantCaballos" , required=true) int cantCaballos   
    )
    {
        
        ReporteEjercito reporteRta = new ReporteEjercito();
        
        Ejercito ejercito = ejercitoService.crearEjercitoFast(cantSoldados , cantCaballos ,"ROJO2", "#F00");
        
        List<Guerrero> arrGuerreros = ejercito.getArrGuerreros();
        
        reporteRta = ejercitoService.reciboColeccionYCalculoTotalesPunto1(arrGuerreros , null);
        
        return reporteRta;
    }
    
    
//    @RequestMapping(value = "generoEjercitoRapidoByVocacion/{cantSoldados}/{cantCaballos}/{vocacion}")
//    public ReporteEjercito generoEjercitoRapidoByVocacion
//    (
//        @PathVariable(value = "cantSoldados" , required=true) int  cantSoldados,   
//        @PathVariable(value = "cantCaballos" , required=true) int cantCaballos , 
//        @PathVariable(value = "vocacion" , required=true) String vocacion   
//    )
//    {
//        System.out.println("VOCACION:" + vocacion);
//        
//        ReporteEjercito reporteRta = new ReporteEjercito();
//        
//        Ejercito ejercito = ejercitoService.crearEjercitoFast(cantSoldados , cantCaballos ,"ROJO2", "#F00");
//        
//        List<Guerrero> arrGuerreros = ejercito.getArrGuerreros();
//        
//        reporteRta = ejercitoService.reciboColeccionYCalculoTotalesPunto3(arrGuerreros , vocacion);
//        
//        return reporteRta;
//    }
    
}

