package com.alurachallenge.conversor.recursos;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class OpcionElegida {
    Scanner teclado1 = new Scanner(System.in);
    Scanner teclado2 = new Scanner(System.in);
    Conversor conversor = new Conversor();
    Archivos archivos = new Archivos();
    int opcion = 10;
    double cantidadAConvertir;


    String opcionValida;
    String newmoneda;
    String oldmoneda;
    String textoDeConversion = "La Cantidad de %.2f[%s] es igual a %.2f[%s]\nLa tasa de conversión es de :%.4f";

    //Elige y verifica si es una opcion valida
    public int elegirUnaOpcion() {
        opcionValida = teclado1.next();
        if (esunaOpcionValida(opcionValida, "I") && opcion >= 0 && opcion <= 8) {
            if (opcion != 0) {
                if (opcion != 7 && opcion != 8) {
                    System.out.println("Cantidad a covertir:");
                    opcionValida = teclado1.next();
                    if (!esunaOpcionValida(opcionValida, "D")) {
                        opcion=10;
                    }
                }
                elegir(opcion);
            }
        } else {
            System.out.println("Por favor, elegir una opción correcta");
        }
        System.out.println("\n");
        return opcion;
    }

    public void elegir(int opcion) {
        boolean comprobar = false;
        TipoDeCambio tipodecambio;
        String contenido;
        switch (opcion) {
            case 1:
                tipodecambio = conversor.convertir("USD", "ARS", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 2:
                tipodecambio = conversor.convertir("ARS", "USD", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 3:
                tipodecambio = conversor.convertir("USD", "BRL", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 4:
                tipodecambio = conversor.convertir("BRL", "USD", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 5:
                tipodecambio = conversor.convertir("USD", "COP", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 6:
                tipodecambio = conversor.convertir("COP", "USD", cantidadAConvertir);
                contenido = String.format(textoDeConversion,
                        cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                archivos.mostrarYguardar(contenido);
                break;
            case 7:
                boolean salir=false;
                try {
                    archivos.mostrarMonedas();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //Comprueba si existe una coincidencia con alguna moneda enlistada
                while (!comprobar) {
                    System.out.println("(teclee SALIR para volver al menu principal)\nEscriba el codigo de su moneda principal:");
                    oldmoneda = teclado2.next();
                    if (oldmoneda.equalsIgnoreCase("salir")) {
                        salir=true;
                        break;
                    }
                    comprobar = archivos.comprobarExistencia(oldmoneda);
                    if (comprobar) {
                        System.out.println("Ahora la moneda que quiere obtener:");
                        newmoneda = teclado2.next();
                        comprobar = archivos.comprobarExistencia(newmoneda);
                    }
                }
                if (!salir)
                {
                    System.out.println("Cantidad a covertir:");
                    cantidadAConvertir = teclado2.nextDouble();
                    tipodecambio = conversor.convertir(oldmoneda, newmoneda, cantidadAConvertir);
                    contenido = String.format(textoDeConversion,
                            cantidadAConvertir, tipodecambio.base_code(), tipodecambio.conversion_result(), tipodecambio.target_code(), tipodecambio.conversion_rate());
                    archivos.mostrarYguardar(contenido);
                }
                break;
            case 8:
                archivos.mostrarHistorial();
                break;
            default:
                break;
        }
    }

    //El tipo de verificacion es "D"=Double I=Int
    public boolean esunaOpcionValida(String cadena, String tipoDeVerificacion) {
        double dobleDePrueba;
        if (tipoDeVerificacion.equalsIgnoreCase("D"))
        {
            try {
                // Intenta convertir la cadena a un entero
                dobleDePrueba = parseDouble(cadena);
                cantidadAConvertir=dobleDePrueba;
                return true;
            } catch (NumberFormatException e1) {
                    return false;
                }
        } else if (tipoDeVerificacion.equalsIgnoreCase("I"))
        {
            try {
                // Intenta convertir la cadena a un entero
                int entero = Integer.parseInt(cadena);
                opcion=entero;
                return true;
            } catch (NumberFormatException e1) {
                    return false;
                }
        }else{return false;}
    }
}

