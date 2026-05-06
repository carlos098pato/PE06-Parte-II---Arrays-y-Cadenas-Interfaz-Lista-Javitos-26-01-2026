package alojamiento;
import java.io.Serializable;

/**
 * Clase que representa un alojamiento turístico.
 * 
 * @author Carlos
 * @version 1.0
 */
public class Alojamiento implements Comparable<Alojamiento>, Serializable {

    private String nombre;
    private int capacidad;
    private double tarifa;
    private boolean tieneChimenea;
    private boolean tieneJacuzzi;
    private boolean alquiladaAhora;
    private int numVecesAlquilada;

    /**
     * Constructor del alojamiento.
     * alquiladaAhora se inicializa a false y numVecesAlquilada a 0.
     * 
     * @param nombre Nombre del alojamiento
     * @param capacidad Capacidad máxima (>0)
     * @param tarifa Tarifa por noche (>0)
     * @param tieneChimenea Indica si tiene chimenea
     * @param tieneJacuzzi Indica si tiene jacuzzi
     */
    public Alojamiento(String nombre, int capacidad, double tarifa,
                        boolean tieneChimenea, boolean tieneJacuzzi) {

        if (capacidad <= 0)
            throw new IllegalArgumentException("Capacidad debe ser mayor que 0");

        if (tarifa <= 0)
            throw new IllegalArgumentException("Tarifa debe ser mayor que 0");

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tarifa = tarifa;
        this.tieneChimenea = tieneChimenea;
        this.tieneJacuzzi = tieneJacuzzi;
        this.alquiladaAhora = false;
        this.numVecesAlquilada = 0;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public double getTarifa() { return tarifa; }
    public boolean getTieneChimenea() { return tieneChimenea; }
    public boolean getTieneJacuzzi() { return tieneJacuzzi; }
    public boolean estaAlquiladaAhora() { return alquiladaAhora; }
    public int getNumVecesAlquilada() { return numVecesAlquilada; }

    // Setters con validación
    public void setCapacidad(int capacidad) {
        if (capacidad > 0)
            this.capacidad = capacidad;
    }

    public void setTarifa(double tarifa) {
        if (tarifa > 0)
            this.tarifa = tarifa;
    }

    /**
     * Marca el alojamiento como alquilado e incrementa contador.
     */
    public void alquilar() {
        if (!alquiladaAhora) {
            alquiladaAhora = true;
            numVecesAlquilada++;
        }
    }

    /**
     * Libera el alojamiento.
     */
    public void liberar() {
        alquiladaAhora = false;
    }

    @Override
    public String toString() {
        return "Alojamiento: " + nombre +
                " | Capacidad: " + capacidad +
                " | Tarifa: " + tarifa +
                " | Alquilada: " + alquiladaAhora +
                " | Veces alquilada: " + numVecesAlquilada;
    }

    @Override
    public int compareTo(Alojamiento o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
}

