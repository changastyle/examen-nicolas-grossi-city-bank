package com.nicolasgrossi;

import com.nicolasgrossi.modelo.Guerrero;
import java.util.ArrayList;
import java.util.List;

public class MasterController
{
    public final static double multiplicadorDano = 1.0;
    public final static double multiplicadorDefensa = 1.0;
    public final static double multiplicadorVelocidad = 1.0;
    public final static double aumentoDanoSiCaballo = 3.0;
    public final static double aumentoVelocidadSiCaballo = 10.0;
    public final static int maxCantEjercitos = 50;
    
    //ESPADACHINES:
    public final static double attEspadachin = 5.0;
    public final static double defEspadachin = 5.0;
    public final static double velEspadachin = 3.0;
    
    //ARQUEROS:
    public final static double attArqueros = 9.0;
    public final static double defArqueros = 1.0;
    public final static double velArqueros = 7.0;
    
    public static int cantPlayers = 0 ;
    
    public static int aumentarCantPlayers()
    {
        if(cantPlayers >= 0)
        {
            cantPlayers++;
        }
        
        int cantRta = cantPlayers;
        
        return cantPlayers;
    }
    public static int disminuirCantPlayers()
    {
        if(cantPlayers > 0)
        {
            cantPlayers--;
        }
        
        int cantRta = cantPlayers;
        
        return cantPlayers;
    }
    
    
    public static int generarNumero(int max)
    {
        int random = (int) ((Math.random() * max) + 1);
        
        return random;
    }
    
    public static List<Guerrero> filtrarPorRol(List<Guerrero> arrRecibido , String nombreVocacion)
    {
        List<Guerrero> arrRta = new ArrayList<>();
        
        for(Guerrero guerreroLoop : arrRecibido)
        {
            if(nombreVocacion.equalsIgnoreCase("JINETE"))
            {
                if(guerreroLoop.getRol().getId() == 3 )
                {
                    arrRta.add(guerreroLoop);
                }
            }
            if(nombreVocacion.equalsIgnoreCase("ESPADACHIN"))
            {
                if(guerreroLoop.getRol().getId() == 1 )
                {
                    arrRta.add(guerreroLoop);
                }
            }
            if(nombreVocacion.equalsIgnoreCase("ARQUERO"))
            {
                if(guerreroLoop.getRol().getId() == 2 )
                {
                    arrRta.add(guerreroLoop);
                }
            }
        }
        
        return arrRta;
    }
}
