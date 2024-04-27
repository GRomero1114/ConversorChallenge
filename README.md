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

---Vers 2---

Se agrego al Menu :

 7)Elegir otro tipos de monedas:  Se encarga de mostrar los codigos junto con los paises a los que pertenecen para elegir un nuevo tipo de moneda.
 Primero se debe elegir la moneda Principal(o base) y luego la moneda secundaria(target) mediante sus respectivos codigos(Tambien se puede salir al menu principal al teclear "Salir").
 Por ultimo se escribe el valor que quiere convertir.
 Ejp.
 Moneda principal : USD
 Moneda Target : Ars
 La conversion se realizará USD ->> Ars

8)Ver Historial de conversión: Muestra, si existe, el historial de conversion de cada vez que se realizo alguna de las mismas.
Ejp
Fecha y Hora de la conversion: 2024-04-27/Hs: 01:38:21
La Cantidad de 2500,00[USD] es igual a 2161875,00[ARS]
La tasa de conversión es de :864,7500

En cuanto al codigo:
-Se cambio la forma de realizar la comprobación del caracter ingresado por un metodo que permitiara verificar tambien si es un double de forma que se puede usar tambien con el Valor que se quiere convertir.
-Ahora la Clase Principal se encarga de llamar a las Clases Menu y OpcionElegida para que funcione la aplicacion(Antes solo llamaba al menu y Menu se encargaba de hacer todo el resto)
-Se agregaron Funciones y metodos para hacer funcionar los extras del Challenge(Elegir otro tipo de moneda, hitorial y Java.time), ademas de dejar a la clase Menu solo como un void que muestra Menus por si se necesitaba agregar otros menus diferentes:
Class OpcionElegida:
+public int elegirUnaOpcion()
+public boolean esunaOpcionValida(String cadena, String tipoDeVerificacion)
Class Archivos:
+public void mostrarMonedas()
+public boolean comprobarExistencia()
+public void mostrarYguardar(String nuevaConversion)
+public void  mostrarHistorial()
  
