package com.restaurantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//toca importar el model para poder usarlo en el metodo hola, (enviar informacion al html)
import org.springframework.web.bind.annotation.GetMapping;

@Controller //dependecia spring
public class HelloController {

    @GetMapping("restaurants/hola")//ESTO VINCULA EL METODO GET HTTP (OBTENER INFORCMACION) CON EL METODO QUE SE LLAMA HOLA, CUANDO SE HAGA UNA PETICION GET A LA URL RAIZ ("/") SE EJECUTARA EL METODO HOLA
    public String hola(Model model){//metodo llamado hola, que reciba un model y devuelva un string+
        return "restaurants/hola";//ESTO LE DICE A SPRING QUE CUANDO SE HAGA UNA PETICION GET A LA URL RAIZ ("/") SE EJECUTARA EL METODO HOLA Y SE DEVOLVERA LA VISTA LLAMADA "HOLA" (QUE DEBE ESTAR EN LA CARPETA DE VISTAS, NORMALMENTE EN src/main/resources/templates
    }

    @GetMapping("restaurants/adios")
    public String adios(Model model){
        model.addAttribute("mensaje", "Adios mundo cruel");//ESTO AGREGA UN ATRIBUTO AL MODELO CON EL NOMBRE "MENSAJE" Y EL VALOR "ADIOS MUNDO CRUEL", ESTE ATRIBUTO PUEDE SER USADO EN LA VISTA PARA MOSTRAR INFORMACION DINAMICA

        return "restaurants/adios";
    }

}
