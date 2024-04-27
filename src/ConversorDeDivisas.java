import com.alurachallenge.conversor.recursos.Menu;
import com.alurachallenge.conversor.recursos.OpcionElegida;

public class ConversorDeDivisas {
    public static void main(String[] args) {
        Menu menu = new Menu();
        OpcionElegida opcionlegida = new OpcionElegida();
        int opcion = 10;
        while (opcion != 0) {
            menu.inicializarConversor();
            opcion = opcionlegida.elegirUnaOpcion();
        }
        System.out.println("Aplicaión Finalizada");
    }
}
