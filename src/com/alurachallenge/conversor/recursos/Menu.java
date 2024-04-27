package com.alurachallenge.conversor.recursos;


public class Menu {
    //Aqui van los menus si hubiera mas de uno
    public void mostrarMenuPrincipal(){
        System.out.println("""
                *******************************
                1)Dólar ->> Peso Argentino
                2)Peso Argentino ->> Dólar
                3)Dólar ->> Real brasileño
                4)Real brasileño ->> Dólar
                5)Dólar ->> Peso Colombiano
                6)Peso Colombiano ->> Dólar
                7)Elegir otro tipos de monedas
                8)Ver Historial de conversion
                
                0)Salir
                *******************************
                Elegir una opción:
                """);
    }
}
