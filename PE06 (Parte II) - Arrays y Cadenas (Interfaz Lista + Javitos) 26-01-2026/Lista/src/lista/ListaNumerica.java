package lista;
/**
 * Implementación de la interfaz Lista usando arrays.
 * Simula el comportamiento de una lista enlazada.
 * 
 * @author carlos
 * @version 1.0
 * @see Lista
 */ 
public class ListaNumerica implements Lista {

    /** Array que almacena los elementos de la lista */
    private final int[] lista;

    /** Tamaño máximo permitido */
    public static final int TAM_MAX = 100;

    /** Tamaño actual de la lista */
    private int tamanyo;

    /**
     * Constructor por defecto.
     * Inicializa la lista vacía.
     */
    public ListaNumerica() {
        lista = new int[TAM_MAX];
        tamanyo = 0;
    }

    @Override
    public int getTamanyo() {
        return tamanyo;
    }

    @Override
    public void insertarAlFinal(int valor) {
        if (tamanyo >= TAM_MAX) {
            System.err.println("Error: lista llena");
            return;
        }
        lista[tamanyo] = valor; // Se inserta al final
        tamanyo++;
    }

    @Override
    public void insertarAlPrincipio(int valor) {
        if (tamanyo >= TAM_MAX) {
            System.err.println("Error: lista llena");
            return;
        }

        // Desplazamos todos los elementos a la derecha
        for (int i = tamanyo; i > 0; i--) {
            lista[i] = lista[i - 1];
        }

        lista[0] = valor;
        tamanyo++;
    }

    @Override
    public void insertarEnLaPosicion(int posicion, int valor) {
        if (tamanyo >= TAM_MAX) {
            System.err.println("Error: lista llena");
            return;
        }

        if (posicion < 0 || posicion > tamanyo) {
            System.err.println("Error: posición inválida");
            return;
        }

        // Desplazamiento a la derecha desde la posición indicada
        for (int i = tamanyo; i > posicion; i--) {
            lista[i] = lista[i - 1];
        }

        lista[posicion] = valor;
        tamanyo++;
    }

    @Override
    public void eliminarLaPrimera() {
        if (tamanyo == 0) {
            System.err.println("Error: lista vacía");
            return;
        }

        // Desplazamos los elementos a la izquierda
        for (int i = 0; i < tamanyo - 1; i++) {
            lista[i] = lista[i + 1];
        }

        tamanyo--;
    }

    @Override
    public void eliminarLaUltima() {
        if (tamanyo == 0) {
            System.err.println("Error: lista vacía");
            return;
        }

        tamanyo--; // Basta con reducir el tamaño
    }

    @Override
    public void eliminar(int posicion) {
        if (tamanyo == 0) {
            System.err.println("Error: lista vacía");
            return;
        }

        if (posicion < 0 || posicion >= tamanyo) {
            System.err.println("Error: posición inválida");
            return;
        }

        // Desplazamos los elementos a la izquierda
        for (int i = posicion; i < tamanyo - 1; i++) {
            lista[i] = lista[i + 1];
        }

        tamanyo--;
    }

    @Override
    public int buscar(int n) {
        for (int i = 0; i < tamanyo; i++) {
            if (lista[i] == n) {
                return i; // Devuelve la posición
            }
        }
        return -1; // No encontrado
    }

    @Override
    public void unirDosListas(Lista lista2) {
        if (lista2 == null) {
            System.err.println("Error: la lista a unir es nula");
            return;
        }

        for (int i = 0; i < lista2.getTamanyo(); i++) {
            if (tamanyo >= TAM_MAX) {
                System.err.println("Error: no se pueden unir más elementos");
                return;
            }
            // Se reutiliza el método insertar
            insertarAlFinal(((ListaNumerica) lista2).lista[i]);
        }
    }

    @Override
    public String imprimirLista() {
        return toString();
    }

    @Override
    public String toString() {
        if (tamanyo == 0) {
            return "Lista vacía";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanyo; i++) {
            sb.append(lista[i]);
            if (i < tamanyo - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
