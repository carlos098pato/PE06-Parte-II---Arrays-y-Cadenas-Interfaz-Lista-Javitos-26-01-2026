package alojamiento;
/**
 * Clase principal de la aplicación.
 * Contiene el método main donde se prueban todas las funcionalidades.
 * 
 * @author Carlos
 * @version 1.0
 * @see Javitos  
 */
public class Principal {

    /**
     * Método principal del programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Creación del gestor del complejo
        Javitos javitos = new Javitos();

        // Alta de clientes
        javitos.altaCliente(new Cliente("Ana López", "12345678A", "ana@mail.com", "Sevilla"));
        javitos.altaCliente(new Cliente("Carlos Ruiz", "87654321B", "carlos@mail.com", "Huelva"));

        // Alta de alojamientos
        javitos.altaAlojamiento(new Alojamiento("Casa Roble", 4, 80.0, true, false));
        javitos.altaAlojamiento(new Alojamiento("Casa Encina", 6, 120.0, true, true));

        // Listados
        System.out.println("=== LISTADO DE CLIENTES ===");
        javitos.listadoClientes();

        System.out.println("\n=== LISTADO DE ALOJAMIENTOS ===");
        javitos.listadoAlojamientos();
    }
}
