package com.alurachallenge.conversor.recursos;

public class OpcionElegida {
    //Menu menu = new Menu();
    Conversor conversor= new Conversor();
    String textoDeConversion= "La Cantidad de %.2f[%s] es igual a %.2f[%s]\nLa tasa de conversión es de :%.4f";

    public void elegir(int opcion,double monto)
    {
        TipoDeCambio tipodecambio;
        switch (opcion) {
            case 1:
                tipodecambio=conversor.convertir("USD", "ARS", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
            case 2:
                tipodecambio=conversor.convertir("ARS", "USD", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
            case 3:
                tipodecambio=conversor.convertir("USD", "BRL", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
            case 4:
                tipodecambio=conversor.convertir("BRL", "USD", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
            case 5:
                tipodecambio=conversor.convertir("USD", "COP", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
            case 6:
                tipodecambio=conversor.convertir("COP", "USD", monto);
                System.out.println(String.format(textoDeConversion,
                        monto,tipodecambio.base_code(),tipodecambio.conversion_result(),tipodecambio.target_code(),tipodecambio.conversion_rate()));
                break;
        }
    }
}
