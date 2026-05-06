package cliente;
import java.io.Serializable;

/**
 * Clase que representa un cliente.
 * 
 * @author Carlos
 * @version 1.0
 */
public final class Cliente implements Comparable<Cliente>, Serializable {

    private final String nombre;
    private String dni;
    private String email;
    private final String lugarResidencia;
    private int numVecesAlojado;

    /**
     * Constructor del cliente.
     * numVecesAlojado se inicializa a 0.
     * 
     * @param nombre Nombre
     * @param dni DNI válido
     * @param email Email válido
     * @param lugarResidencia Lugar de residencia
     */
    public Cliente(String nombre, String dni, String email, String lugarResidencia) {
        setDni(dni);
        setEmail(email);

        this.nombre = nombre;
        this.lugarResidencia = lugarResidencia;
        this.numVecesAlojado = 0;
    }

    // Expresiones regulares
    private static final String REGEX_DNI = "^[0-9]{8}[A-Za-z]$";
    private static final String REGEX_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$";

    public void setDni(String dni) {
        if (!dni.matches(REGEX_DNI))
            throw new IllegalArgumentException("DNI no válido");
        this.dni = dni;
    }

    public void setEmail(String email) {
        if (!email.matches(REGEX_EMAIL))
            throw new IllegalArgumentException("Email no válido");
        this.email = email;
    }

    public void alojar() {
        numVecesAlojado++;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getEmail() { return email; }
    public String getLugarResidencia() { return lugarResidencia; }
    public int getNumVecesAlojado() { return numVecesAlojado; }

    @Override
    public String toString() {
        return "Cliente: " + nombre +
                " | DNI: " + dni +
                " | Email: " + email +
                " | Veces alojado: " + numVecesAlojado;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
}
