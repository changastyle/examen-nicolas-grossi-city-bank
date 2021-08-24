package com.nicolasgrossi;

import com.nicolasgrossi.modelo.Ejercito;
import com.nicolasgrossi.modelo.Guerrero;
import com.nicolasgrossi.modelo.MovimientoJugador;
import com.nicolasgrossi.modelo.Rol;
import com.nicolasgrossi.service.EjercitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
@org.springframework.web.bind.annotation.RestController
@ComponentScan(basePackages = {"com.nicolasgrossi.modelo","com.nicolasgrossi.ws" , "com.nicolasgrossi.service"})
@EnableWebMvc 
public class ExamenNicolasGrossi 
{
    
    public static void main(String[] args) 
    {
        // 1 - INICIALIZAR SPRING:
        SpringApplication.run(ExamenNicolasGrossi.class, args);
        
        // 2 - HABILITAR LA APP:
        ExamenNicolasGrossi app = new ExamenNicolasGrossi();
       
        // 3 - MSG AL USUARIO:
        System.out.println("PARA VISUALIZAR LA APP INGRESE DESDE SU NAVEGADOR A LA SIGUIENTE DIRECCION: http://localhost:8025/");
        
    }
    
   
    @RequestMapping(value = "/status")
    public String status() 
    {
        return "encendido";
    }
}
