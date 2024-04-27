package com.alurachallenge.conversor.recursos;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/* Todo lo relacionado con lectura y escritura de archivos */

public class Archivos  {
    File divisas = new File("Divisas-Paises.txt");
    File historial = new File("Historial.txt");

    String contenido;
    boolean primeraVez=true;
    ArrayList<String> listaDeCodigos = new ArrayList<>();

    public void mostrarMonedas() throws  IOException{

        FileReader lector= new FileReader(divisas);
        BufferedReader lectura = new BufferedReader(lector);

        contenido=lectura.readLine();
        while (contenido!=null){
            System.out.println(contenido);
            if(primeraVez){
                listaDeCodigos.add(contenido);
            }
            contenido=lectura.readLine();
        }
        lectura.close();
        lector.close();
        primeraVez=false;
        System.out.println("\n");
    }

    public boolean comprobarExistencia(String moneda){
        boolean existe=false;
        int iterador=0;
        if (listaDeCodigos.isEmpty()){
            System.out.println("Esta vacio");
        }else{
            for (String a : listaDeCodigos)
            {
                if (moneda.equalsIgnoreCase(listaDeCodigos.get(iterador).substring(0,3))) {
                    existe = true;
                    break;
                }
                iterador++;
            }
            if (!existe) System.out.println("Por favor ingrese un Codigo correcto\n");
        }
        return  existe;
    }

    public void mostrarYguardar(String nuevaConversion){
        //Mostrar
        System.out.println(nuevaConversion);
        //Guardar
        try {
            if(!historial.exists())
            {
                historial.createNewFile();
            }
            FileWriter escritor = new FileWriter(historial,true);
            BufferedWriter bfescritor = new BufferedWriter(escritor);
            bfescritor.write("Fecha y Hora de la conversion: "+ LocalDate.now() +"/Hs: "+LocalTime.now().withNano(0)+"\n"+nuevaConversion+"\n\n");
            bfescritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void  mostrarHistorial() {
        if(historial.exists())
        {
            System.out.println("***HISTORIAL DE CONVERSIONES***\n");
            try {
            FileReader lector = new FileReader("Historial.txt");
            BufferedReader bfreader= new BufferedReader(lector);

                contenido= bfreader.readLine();
                while (contenido!=null)
                {
                    System.out.println(contenido);
                    contenido=bfreader.readLine();
                }
                bfreader.close();
                System.out.println("*******************************");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            System.out.println("No existe ningun historial");
        }
    }

}
