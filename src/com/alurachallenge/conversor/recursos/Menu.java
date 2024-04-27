package com.alurachallenge.conversor.recursos;

public class Menu {
    OpcionElegida opcionelegida = new OpcionElegida();
    int opcion= 10;

    public void inicializarConversor(){
        while (opcion !=0){
            mostrarMenuPrincipal();
            opcion=opcionelegida.elegirUnaOpcion();
        }
        System.out.println("Aplicaión Finalizada");
    }

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
