Conversor de Monedas-Challenge de Alura-Especialista en BackEnd

El conversor de monedas funciona al elegir una de las opciones de conversion disponibles entre(El menu es generado por la Class "Menu" y la resolucion del Switch por la Class "Opcion elegida" :
1)Dólar ->> Peso Argentino
2)Peso Argentino ->> Dólar
3)Dólar ->> Real brasileño
4)Real brasileño ->> Dólar
5)Dólar ->> Peso Colombiano
6)Peso Colombiano ->> Dólar

Esta opcion genera una variable que en caso de ser un Int prosigue a dar la conversion entre las moenedas elegidas.Caso contrario se pedira elegir una opción correcta.
El encargado de buscar y devolver un Json TipoDeCambio(String base_code, String target_code, double conversion_rate, double conversion_result) lo hace la Class Conversor.
base_code: Moneda Principal que se quiere Cambiar(100USD)
target_code: Moneda Resultante del cambio (Ars)
conversion_rate: Tasa de Conversion en la moneda principal (ejp 800ARS por USD)
conversion_result: Resultado total de la conversion de la moneda(Ejmplo 100 USD = 800000)

En caso de querer finalizar la aplicación se debe elegir la opcion "0"
0) Salir
La misma finaliza la aplicacion mostrando un aviso.


---Esta es la primera version Funcional del Conversor--
