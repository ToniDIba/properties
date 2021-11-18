package com.example.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class Controller1 {

    @Autowired
    PropiedadesArchivo propiedadesArchivo;

    @GetMapping("/valores/")
    String controlador1var1y2()
    {

        Logger logger = LoggerFactory.getLogger(Controller1.class);
        logger.debug ("Var1 contiene: " + propiedadesArchivo.getVar1());
        logger.debug ("Var2 contiene: " + propiedadesArchivo.getVar2());

        return "Ejercicio uso 'application.properties'  " +
        "<br/>" +
        "<br/>" + "Valor de 'VAR1' es: "    + propiedadesArchivo.getVar1() +
        "<br/>" + "Valor de 'My.VAR2' es: " + propiedadesArchivo.getVar2();
    }



    /*
    * VAR3 no existe en 'application.properties', por tanto, se asigna valor por defecto en clase "PropiedadesArchivo"
    * * */
    @GetMapping("/var3/")
    String controlador1var3()
    {

        Logger logger = LoggerFactory.getLogger(Controller1.class);
        logger.debug ("Var3 contiene: " + propiedadesArchivo.getVar3());

        System.out.println("Contenido variable de sistema 'var3': " + System.getenv("var3"));

        return "Valor por defecto para 'VAR3'" +
                "<br/>" +
                "<br/>" + "Valor de 'VAR3' es: " + propiedadesArchivo.getVar3();
    }


}
