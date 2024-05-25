package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", 5);

        // Obtener la colección de puestos del parqueadero
        //Hashtable <String, Puesto> puestos = parqueadero.getPuestos();

        // Imprimir la matriz de puestos
        System.out.println("Matriz de Puestos:");
        System.out.println(parqueadero.getPuestos());
    }
}
