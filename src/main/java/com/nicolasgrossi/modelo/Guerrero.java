package com.nicolasgrossi.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicolasgrossi.MasterController;
import java.io.Serializable;
import com.nicolasgrossi.interfaces.IAccionesGuerrero;

public class Guerrero implements IAccionesGuerrero , Serializable
{
    private int id;
    private String nombre;
    private String email;
    private String passw;
    private MovimientoJugador casilleroActual;
    
    private double atqSkill;
    private double defSkill;
    private double velSkill;
    
    private boolean tieneCaballo;
    
//    @JsonIgnore
    private Rol rol;

    public Guerrero(String nombre, String email, String passw, MovimientoJugador casilleroActual, Rol rol)
    {
        this.nombre = nombre;
        this.email = email;
        this.passw = passw;
        this.casilleroActual = casilleroActual;
        this.rol = rol;
        this.atqSkill = rol.getAtt();
        this.defSkill = rol.getDef();
        this.velSkill = rol.getVel();
        
//        if(rol.getVocacion().equalsIgnoreCase("JINETE"))
//        {
//            tieneCaballo = true;
//        }
        
    }
    
    
    
    
    
    @Override
    public double atacar(Guerrero enemigo)
    {
        double danoGenerado = 0;
        
        // 1 - CALCULAR LA DEFENSA DEL ENEMIGO:
        double defensaEnemigo = enemigo.calcularPtosDefensa();
        
        // 2 - CALCULAR MI ATTAQUE:
        double attMio = this.calcularPtosAtt();
        
        // 3 - A MI ATAQUE LE RESTO LO QUE DEFIENDE EL ENEMIGO:
        danoGenerado = attMio - defensaEnemigo ;   
        
        return danoGenerado;
    }

    
    
    
    @Override
    public MovimientoJugador avanzar(Guerrero guererro , char direccion , boolean verbose)
    {
        // 1 - OBTENGO LAS COORDENADAS X E Y ACTUALES DEL JUGADOR:
        int x = casilleroActual.getX();
        int y = casilleroActual.getY();
        
        
        // 2 - MUEVO AL JUGADOR EN BASE A LA FLECHITA RECIBIDA:
        MovimientoJugador movimientoRta = new MovimientoJugador(x,y);
        
        if(direccion == IAccionesGuerrero.izquierda)
        {
            x -= 1;
        }
        else if(direccion == IAccionesGuerrero.derecha)
        {
            x += 1;
        }
        else if(direccion == IAccionesGuerrero.arriba)
        {
            y -= 1;
        }
        
        else if(direccion == IAccionesGuerrero.abajo)
        {
            y += 1;
        }
        
        
        // 3 - CALCULO EL DELAY QUE VA A TENER SEGUN SU VELOCIDAD, PARA QUE EL FRONTEND-CLIENTE TENGA QUE ESPERAR: 
        double delay = (1 - this.calcularVelocidad());
        movimientoRta.setTiempoDelay(delay);
        
        
        // 4 - SETEO EL MOVIMIENTO ACTUAL:
        this.setCasilleroActual(movimientoRta);
        
        return movimientoRta;
    }

    public double calcularPtosAtt()
    {
        double attRta = 0;
        
        // 1 - MULTIPLICA LA HABILIDAD DE ATT POR EL MULTIPLICADOR GLOBAL DEL JUEGO
        double danoOnlyPlayer = (atqSkill * MasterController.multiplicadorDano) ;   
        double danoOnlyCaballo = 0;
        
        // 2 - CALCULO EL DAÑO QUE AUMENTA SI TIENE CABALLO:
        if(this.tieneCaballo)
        {
            danoOnlyCaballo = (MasterController.aumentoDanoSiCaballo * MasterController.multiplicadorDano) ;
        }
        
        // 3 - SUMATORIA DE AMBOS DANOS:
        attRta = danoOnlyPlayer + danoOnlyCaballo;
        
        return attRta;
    }
    public double calcularPtosDefensa()
    {
        double defensaRta = 0;
        
        // 1 - MULTIPLICA SU DEFF X EL MULTIPLICADOR DEFENSA DEL JUEGO:
        defensaRta = this.defSkill * MasterController.multiplicadorDefensa;
        
        return defensaRta;
    }
    public double calcularVelocidad()
    {
        double velocidadRta = 0;
        double velocidadCaballo = 0;
        
        
        
        // 1 - MULTIPLICA SU DEFF X EL MULTIPLICADOR DEFENSA DEL JUEGO:
        if(this.tieneCaballo)
        {
            velocidadCaballo += MasterController.aumentoVelocidadSiCaballo;
        }
        
        velocidadRta = ((this.velSkill + velocidadCaballo) * MasterController.multiplicadorVelocidad);
        
        
        
        return velocidadRta;
    }
    
    public void obtieneCaballo()
    {
        this.tieneCaballo = true;
    }
    public void pierdeCaballo()
    {
        this.tieneCaballo = false;
    }
    public String getCalcularNombreRol()
    {
        String nombreRolRta = "";
        
        if(this.tieneCaballo)
        {
            nombreRolRta = "JINETE - (" + this.rol.getVocacion() + ")";
        }
        else
        {
            nombreRolRta = this.rol.getVocacion();
        }
        
        return nombreRolRta;
    }
    public String getCalcularNombreRol2()
    {
        String nombreRolRta = "";
        
        if(this.tieneCaballo)
        {
            nombreRolRta = "JINETE";
        }
        else
        {
            nombreRolRta = this.getRol().getVocacion();
        }
        
        return nombreRolRta;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //<editor-fold desc="GYS:">

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassw()
    {
        return passw;
    }

    public void setPassw(String passw)
    {
        this.passw = passw;
    }

    public MovimientoJugador getCasilleroActual()
    {
        return casilleroActual;
    }

    public void setCasilleroActual(MovimientoJugador casilleroActual)
    {
        this.casilleroActual = casilleroActual;
    }

    public double getAtqSkill()
    {
        return atqSkill;
    }

    public void setAtqSkill(double atqSkill)
    {
        this.atqSkill = atqSkill;
    }

    public double getDefSkill()
    {
        return defSkill;
    }

    public void setDefSkill(double defSkill)
    {
        this.defSkill = defSkill;
    }

    public double getVelSkill()
    {
        return velSkill;
    }

    public void setVelSkill(double velSkill)
    {
        this.velSkill = velSkill;
    }

    public boolean isTieneCaballo()
    {
        return tieneCaballo;
    }

    public void setTieneCaballo(boolean tieneCaballo)
    {
        this.tieneCaballo = tieneCaballo;
    }
    public Rol getRol()
    {
        return rol;
    }

    public void setRol(Rol rol)
    {
        this.rol = rol;
    }

    //</editor-fold>

    @Override
    public String toString()
    {
        String calculoAtt = String.valueOf(this.calcularPtosAtt());
        String calculoDef = String.valueOf(this.calcularPtosDefensa());
        String calculoVel = String.valueOf(this.calcularVelocidad());
        
        String tieneCab = "";
        if(tieneCaballo)
        {
            tieneCab = " - CABALLO - ";
        }
        String calculos = "ATT = " + calculoAtt + " - DEF = " + calculoDef + " - VEL: " + calculoVel;
        return "Guerrero [" + getCalcularNombreRol() + "] (" + calculos + ")" + tieneCab + "{" + "id=" + id + ", nombre=" + nombre + ", casilleroActual=" + casilleroActual  + ", rol=" + rol + '}';
    }
    
}
