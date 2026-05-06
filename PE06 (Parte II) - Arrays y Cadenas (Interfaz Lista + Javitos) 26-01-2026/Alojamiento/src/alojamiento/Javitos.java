package alojamiento;
/**
 * Clase que gestiona el complejo rural "Los Javitos".
 * Permite administrar clientes y alojamientos utilizando arrays.
 * 
 * @author Carlos
 * @version 1.0
 * @see Cliente
 * @see Alojamiento
 */
public class Javitos {

    /** Array de alojamientos (máximo 15) */
    private final Alojamiento[] alojamientos;

    /** Array de clientes (máximo 100) */
    private final Cliente[] clientes; 

    /** Número actual de alojamientos */
    private int numAlojamientos;

    /** Número actual de clientes */
    private int numClientes;

    /**
     * Constructor de la clase Javitos.
     * Inicializa los arrays y los contadores.
     */
    public Javitos() {
        alojamientos = new Alojamiento[15];
        clientes = new Cliente[100];
        numAlojamientos = 0;
        numClientes = 0;
    }

    /**
     * Da de alta un nuevo cliente.
     * 
     * @param cliente cliente a añadir
     */
    public void altaCliente(Cliente cliente) {
        if (cliente == null) {
            System.err.println("Error: cliente nulo");
            return;
        }
        if (numClientes >= clientes.length) {
            System.err.println("Error: no se pueden añadir más clientes");
            return;
        }
        clientes[numClientes++] = cliente;
    }

    /**
     * Da de baja un cliente a partir de su DNI.
     * 
     * @param dni DNI del cliente a eliminar
     */
    public void bajaCliente(String dni) {
        if (dni == null) {
            System.err.println("Error: DNI nulo");
            return;
        }

        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getDni().equalsIgnoreCase(dni)) {

                // Desplazamos los elementos para no dejar huecos
                for (int j = i; j < numClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }

                clientes[--numClientes] = null;
                return;
            }
        }

        System.err.println("Cliente no encontrado");
    }

    /**
     * Da de alta un nuevo alojamiento.
     * 
     * @param alojamiento alojamiento a añadir
     */
    public void altaAlojamiento(Alojamiento alojamiento) {
        if (alojamiento == null) {
            System.err.println("Error: alojamiento nulo");
            return;
        }
        if (numAlojamientos >= alojamientos.length) {
            System.err.println("Error: no se pueden añadir más alojamientos");
            return;
        }
        alojamientos[numAlojamientos++] = alojamiento;
    }

    /**
     * Da de baja un alojamiento por su nombre.
     * 
     * @param nombre nombre del alojamiento a eliminar
     */
    public void bajaAlojamiento(String nombre) {
        if (nombre == null) {
            System.err.println("Error: nombre nulo");
            return;
        }

        for (int i = 0; i < numAlojamientos; i++) {
            if (alojamientos[i].getNombre().equalsIgnoreCase(nombre)) {

                // Desplazamos los elementos para mantener el array compacto
                for (int j = i; j < numAlojamientos - 1; j++) {
                    alojamientos[j] = alojamientos[j + 1];
                }

                alojamientos[--numAlojamientos] = null;
                return;
            }
        }

        System.err.println("Alojamiento no encontrado");
    }

    /**
     * Muestra un listado de clientes ordenado alfabéticamente por nombre.
     */
    public void listadoClientes() {
        Cliente[] copia = new Cliente[numClientes];

        // Copia del array original
        System.arraycopy(clientes, 0, copia, 0, numClientes);

        // Ordenación alfabética (burbuja)
        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i].compareTo(copia[j]) > 0) {
                    Cliente aux = copia[i];
                    copia[i] = copia[j];
                    copia[j] = aux;
                }
            }
        }

        // Impresión del listado
        for (Cliente c : copia) {
            System.out.println(c);
        }
    }

    /**
     * Muestra un listado de alojamientos ordenado alfabéticamente por nombre.
     */
    public void listadoAlojamientos() {
        Alojamiento[] copia = new Alojamiento[numAlojamientos];

        System.arraycopy(alojamientos, 0, copia, 0, numAlojamientos);

        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i].compareTo(copia[j]) > 0) {
                    Alojamiento aux = copia[i];
                    copia[i] = copia[j];
                    copia[j] = aux;
                }
            }
        }

        for (Alojamiento a : copia) {
            System.out.println(a);
        }
    }

    /**
     * Muestra los clientes ordenados por número de veces alojado (descendente).
     */
    public void topClientes() {
        Cliente[] copia = new Cliente[numClientes];
        System.arraycopy(clientes, 0, copia, 0, numClientes);

        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i].getVecesAlojado() < copia[j].getVecesAlojado()) {
                    Cliente aux = copia[i];
                    copia[i] = copia[j];
                    copia[j] = aux;
                }
            }
        }

        for (Cliente c : copia) {
            System.out.println(c);
        }
    }

    /**
     * Muestra los alojamientos ordenados por número de veces alquilado (descendente).
     */
    public void topAlojamientos() {
        Alojamiento[] copia = new Alojamiento[numAlojamientos];
        System.arraycopy(alojamientos, 0, copia, 0, numAlojamientos);

        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i].getVecesAlquilado() < copia[j].getVecesAlquilado()) {
                    Alojamiento aux = copia[i];
                    copia[i] = copia[j];
                    copia[j] = aux;
                }
            }
        }

        for (Alojamiento a : copia) {
            System.out.println(a);
        }
    }
}
