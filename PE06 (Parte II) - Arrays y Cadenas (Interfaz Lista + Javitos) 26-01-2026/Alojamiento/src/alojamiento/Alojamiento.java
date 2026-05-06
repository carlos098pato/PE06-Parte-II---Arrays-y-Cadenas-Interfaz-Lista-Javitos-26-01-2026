package alojamiento;
/**
 * Clase que representa un alojamiento del complejo rural Los Javitos.
 * Contiene información sobre sus características y su uso.
 * 
 * @author Carlos  
 * @version 1.0
 * @see Javitos
 */
public class Alojamiento {

    /** Nombre del alojamiento */
    private String nombre;

    /** Capacidad máxima de personas */
    private int capacidad;

    /** Tarifa por noche */
    private double tarifaNoche;

    /** Indica si el alojamiento tiene chimenea */
    private boolean chimenea;

    /** Indica si el alojamiento tiene jacuzzi */
    private boolean jacuzzi;

    /** Indica si el alojamiento está alquilado actualmente */
    private boolean alquilado;

    /** Número de veces que el alojamiento ha sido alquilado */
    private int vecesAlquilado;

    /**
     * Constructor de la clase Alojamiento.
     * 
     * @param nombre nombre del alojamiento
     * @param capacidad número máximo de personas
     * @param tarifaNoche tarifa por noche
     * @param chimenea indica si tiene chimenea
     * @param jacuzzi indica si tiene jacuzzi
     */
    public Alojamiento(String nombre, int capacidad, double tarifaNoche,
                       boolean chimenea, boolean jacuzzi) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre del alojamiento no válido");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad incorrecta");
        }
        if (tarifaNoche <= 0) {
            throw new IllegalArgumentException("Tarifa incorrecta");
        }

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tarifaNoche = tarifaNoche;
        this.chimenea = chimenea;
        this.jacuzzi = jacuzzi;
        this.alquilado = false;
        this.vecesAlquilado = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTarifaNoche() {
        return tarifaNoche;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public int getVecesAlquilado() {
        return vecesAlquilado;
    }

    /**
     * Establece si el alojamiento está alquilado.
     * Si pasa a alquilado, incrementa el contador.
     * 
     * @param alquilado estado del alojamiento
     */
    public void setAlquilado(boolean alquilado) {
        if (alquilado && !this.alquilado) {
            vecesAlquilado++; // Se incrementa solo al alquilar
        }
        this.alquilado = alquilado;
    }

    /**
     * Compara dos alojamientos por su nombre.
     * 
     * @param otro alojamiento a comparar
     * @return -1 si es menor, 0 si es igual, 1 si es mayor
     */
    public int compareTo(Alojamiento otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return "Alojamiento: " + nombre +
               " | Capacidad: " + capacidad +
               " | Tarifa/noche: " + tarifaNoche +
               " | Chimenea: " + chimenea +
               " | Jacuzzi: " + jacuzzi +
               " | Veces alquilado: " + vecesAlquilado;
    }
}
