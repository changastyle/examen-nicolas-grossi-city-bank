package com.nicolasgrossi.service;

import com.nicolasgrossi.MasterController;
import com.nicolasgrossi.interfaces.IGuerreroService;
import com.nicolasgrossi.interfaces.IRolService;
import com.nicolasgrossi.modelo.Guerrero;
import com.nicolasgrossi.modelo.Rol;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository @ComponentScan
public class RolService implements IRolService
{
    public Rol dameRolEspadachin()
    {
        Rol rolEspadachin = new Rol(1, "ESPADACHIN", MasterController.attEspadachin,MasterController.defEspadachin , MasterController.velEspadachin);
        return rolEspadachin;
    }
    public Rol dameRolArquero()
    {
        Rol rolArquero = new Rol(2, "ARQUERO", MasterController.attArqueros,MasterController.defArqueros , MasterController.velArqueros);
        return rolArquero;
    }
    public Rol dameRolJinete(double att , double def , double vel)
    {
        Rol rolArquero = new Rol(3, "JINETE", att,def,vel);
        return rolArquero;
    }

}
