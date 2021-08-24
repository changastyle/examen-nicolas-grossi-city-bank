package com.nicolasgrossi.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class wsWeb
{
    
    @RequestMapping(value = {"/","/home" , "/inicio"})
    public static String home()
    {
        return "inicio/index";
    }
    
    
    @RequestMapping(value = "/{carpeta}/{archivo}")
    public static String web
    (
        @PathVariable(name = "carpeta") String carpeta,
        @PathVariable(name = "archivo") String archivo
    )
    {
        
        System.out.println("CARPETA:" + carpeta);
        System.out.println("ARCHIVO:" + archivo);
        return "" + carpeta + "/" + archivo;
    }
}
