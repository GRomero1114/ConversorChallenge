package com.alurachallenge.conversor.recursos;

import java.util.Scanner;

public class Menu {

    OpcionElegida opcionelegida = new OpcionElegida();
    int opcion= 10;
    boolean vof;
    double cantidadAConvertir;

    public void mostrarMenu(){
        while (opcion !=0){
            Scanner tecladoIn= new Scanner(System.in);
            System.out.println("""
                *******************************
                1)Dólar ->> Peso Argentino
                2)Peso Argentino ->> Dólar
                3)Dólar ->> Real brasileño
                4) Real brasileño ->> Dólar
                5)Dólar ->> Peso Colombiano
                6)Peso Colombiano ->> Dólar
               
                0)Salir
                *******************************
                Elegir una opción:
                """);

            vof=tecladoIn.hasNextInt();
            if (vof)
            {

                opcion= Integer.valueOf(tecladoIn.nextLine());
                if (opcion>=0 && opcion<=6){
                    if (opcion != 0){
                        System.out.println("Cantidad a covertir:");
                        cantidadAConvertir= tecladoIn.nextDouble();
                        opcionelegida.elegir(opcion,cantidadAConvertir);
                    }
                }
            }else{System.out.println("Por favor, elegir una opción correcta");}
            System.out.println("\n");

        }

        System.out.println("Aplicaión Finalizada");
    }

}
