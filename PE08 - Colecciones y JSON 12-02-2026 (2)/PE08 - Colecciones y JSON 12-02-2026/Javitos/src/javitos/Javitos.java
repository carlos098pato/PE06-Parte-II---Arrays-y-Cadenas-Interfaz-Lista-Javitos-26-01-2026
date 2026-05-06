package javitos;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.google.gson.reflect.TypeToken;

/**
 * Clase principal que gestiona clientes y alojamientos.
 * 
 * @author Carlos
 * @version 1.0
 */
public class Javitos {

    private List<Alojamiento> alojamientos;
    private List<Cliente> clientes;

    public Javitos() {
        alojamientos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void altaCliente(Cliente c) {
        clientes.add(c);
    }

    public void bajaCliente(String dni) {
        boolean removeIf = clientes.removeIf(c -> c.getDni().equalsIgnoreCase(dni));
    }

    public void altaAlojamiento(Alojamiento a) {
        alojamientos.add(a);
    }

    public void bajaAlojamiento(String nombre) {
        alojamientos.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
    }

    public void listadoClientes() {
        clientes.forEach(System.out::println);
    }

    public void listadoAlojamientos() {
        alojamientos.forEach(System.out::println);
    }

    public void topClientes() {
        clientes.stream()
                .sorted(Comparator.comparingInt(Cliente::getNumVecesAlojado).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    public void topAlojamientos() {
        alojamientos.stream()
                .sorted(Comparator.comparingInt(Alojamiento::getNumVecesAlquilada).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    // ---------------- JSON ----------------

    public void exportClientesToJSON() {
        try (FileWriter writer = new FileWriter("clientes.json")) {
            new Gson().toJson(clientes, writer);
        } catch (IOException e) {
            System.err.println("Error exportando clientes: " + e.getMessage());
        }
    }

    public void importClientesFromJSON() {
        try (FileReader reader = new FileReader("clientes.json")) {
            clientes = new Gson().fromJson(reader,
                    new TypeToken<List<Cliente>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Error importando clientes: " + e.getMessage());
        }
    }

    public void exportAlojamientosToJSON() {
        try (FileWriter writer = new FileWriter("alojamientos.json")) {
            new Gson().toJson(alojamientos, writer);
        } catch (IOException e) {
            System.err.println("Error exportando alojamientos: " + e.getMessage());
        }
    }

    public void importAlojamientosFromJSON() {
        try (FileReader reader = new FileReader("alojamientos.json")) {
            alojamientos = new Gson().fromJson(reader,
                    new TypeToken<List<Alojamiento>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Error importando alojamientos: " + e.getMessage());
        }
    }

    private static class Alojamiento {

        public Alojamiento() {
        }
    }

    private static class Cliente {

        public Cliente() {
        }

        private Object getDni() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class TypeToken<T> {

        public TypeToken() {
        }
    }
}

