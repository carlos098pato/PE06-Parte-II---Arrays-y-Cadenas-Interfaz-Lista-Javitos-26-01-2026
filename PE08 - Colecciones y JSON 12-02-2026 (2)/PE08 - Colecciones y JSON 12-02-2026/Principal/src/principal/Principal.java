package principal;
/**
 * Clase principal de prueba.
 * 
 * @author Carlos
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {

        Javitos app = new Javitos();

        // Crear clientes
        Cliente c1 = new Cliente("Mario Lopez", "12345678A",
                "mario@gmail.com", "Granada");

        // Crear alojamientos
        Alojamiento a1 = new Alojamiento("Pino", 8,
                150.0, true, false);

        app.altaCliente(c1);
        app.altaAlojamiento(a1);

        // Simular alquiler
        a1.alquilar();
        c1.alojar();

        // Mostrar datos
        app.listadoClientes();
        app.listadoAlojamientos();

        // Exportar a JSON
        app.exportClientesToJSON();
        app.exportAlojamientosToJSON();
    }

    private static class Javitos {

        public Javitos() {
        }

        private void listadoClientes() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void listadoAlojamientos() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void exportClientesToJSON() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void exportAlojamientosToJSON() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void altaCliente(Cliente c1) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void altaAlojamiento(Alojamiento a1) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }


    }

    private static class Cliente {

        public Cliente(String mario_Lopez, String a, String mariogmailcom, String granada) {
        }

        private void alojar() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
}
