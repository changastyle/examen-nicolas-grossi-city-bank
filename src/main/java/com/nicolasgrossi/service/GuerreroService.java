package com.nicolasgrossi.service;

import com.nicolasgrossi.MasterController;
import com.nicolasgrossi.interfaces.IGuerreroService;
import com.nicolasgrossi.modelo.Guerrero;
import com.nicolasgrossi.modelo.MovimientoJugador;
import com.nicolasgrossi.modelo.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository @ComponentScan
public class GuerreroService implements IGuerreroService
{
    @Autowired RolService rolService;
    
    public Guerrero crearGuerreroFast(boolean tienecaballo)
    {
        int cantPlayersActual = MasterController.aumentarCantPlayers();
        String nombre = "Guerrero " + cantPlayersActual;
        String email = "email" + cantPlayersActual +"@mail.com";
        String passw = "cambiame";
        
        MovimientoJugador casilleroInicioJuego = new MovimientoJugador(1, 1);
        Rol rol = null;
        
        int random = MasterController.generarNumero(2);
//        int randomTieneCaballo = MasterController.generarNumero(2);
        
        if(tienecaballo)
        {
            if(random == 1)
            {
                rol = rolService.dameRolEspadachin();
            }
            else
            {
                rol = rolService.dameRolArquero();
            }
            rol = rolService.dameRolJinete(rol.getAtt() , rol.getDef(), rol.getVel());
        }
        else
        {
            if(random == 1)
            {
                rol = rolService.dameRolEspadachin();
            }
            else
            {
                rol = rolService.dameRolArquero();
            }
        }
        
        Guerrero guerreroNvo = new Guerrero(nombre, email, passw,casilleroInicioJuego , rol);
        guerreroNvo.setId(cantPlayersActual);
        
        guerreroNvo.setTieneCaballo(tienecaballo);
        
        
        return guerreroNvo;
    }
}
