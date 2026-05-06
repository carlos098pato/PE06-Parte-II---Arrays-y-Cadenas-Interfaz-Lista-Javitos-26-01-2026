package alojamiento;
import java.util.regex.Pattern;
/** 
 * Clase que representa un cliente del complejo rural Los Javitos.
 * 
 * @author Carlos
 * @version 1.0
 * @see Javitos
 */
public final class Cliente {

    /** Nombre y apellidos del cliente */
    private String nombre;

    /** DNI del cliente */
    private String dni;

    /** Email del cliente */
    private String email;

    /** Lugar de residencia del cliente */
    private String residencia;

    /** Número de veces que el cliente se ha alojado */
    private int vecesAlojado;

    /** Expresión regular para validar DNI */
    private static final String REGEX_DNI = "\\d{8}[A-Za-z]";

    /** Expresión regular para validar email */
    private static final String REGEX_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre nombre y apellidos
     * @param dni DNI del cliente
     * @param email email del cliente
     * @param residencia lugar de residencia
     */
    public Cliente(String nombre, String dni, String email, String residencia) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no válido");
        }

        this.nombre = nombre;
        setDni(dni);
        setEmail(email);
        this.residencia = residencia;
        this.vecesAlojado = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getResidencia() {
        return residencia;
    }

    public int getVecesAlojado() {
        return vecesAlojado;
    }

    /**
     * Incrementa el número de estancias del cliente.
     */
    public void incrementarVecesAlojado() {
        vecesAlojado++;
    }

    /**
     * Establece el DNI comprobando la expresión regular.
     * 
     * @param dni DNI a validar
     */
    public void setDni(String dni) {
        if (dni == null || !Pattern.matches(REGEX_DNI, dni)) {
            throw new IllegalArgumentException("DNI no válido");
        }
        this.dni = dni;
    }

    /**
     * Establece el email comprobando la expresión regular.
     * 
     * @param email email a validar
     */
    public void setEmail(String email) {
        if (email == null || !Pattern.matches(REGEX_EMAIL, email)) {
            throw new IllegalArgumentException("Email no válido");
        }
        this.email = email;
    }

    /**
     * Compara dos clientes por su nombre.
     * 
     * @param otro cliente a comparar
     * @return -1 si es menor, 0 si es igual, 1 si es mayor
     */
    public int compareTo(Cliente otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre +
               " | DNI: " + dni +
               " | Email: " + email +
               " | Residencia: " + residencia +
               " | Veces alojado: " + vecesAlojado;
    }
}
