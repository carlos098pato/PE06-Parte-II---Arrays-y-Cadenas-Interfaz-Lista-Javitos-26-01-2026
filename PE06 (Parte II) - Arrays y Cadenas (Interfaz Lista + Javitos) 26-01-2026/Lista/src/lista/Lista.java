package lista;
/**
 * Interfaz que define las operaciones básicas de una lista numérica.
 * 
 * @author Carlos 
 * @version 1.0 
 * @see ListaNumerica
 */
public interface Lista {

    /**
     * Devuelve el tamaño actual de la lista.
     * 
     * @return número de elementos de la lista
     */
    int getTamanyo();

    /**
     * Inserta un valor al final de la lista.
     * 
     * @param valor valor a insertar
     */
    void insertarAlFinal(int valor);

    /**
     * Inserta un valor al principio de la lista.
     * 
     * @param valor valor a insertar
     */
    void insertarAlPrincipio(int valor);

    /**
     * Inserta un valor en una posición concreta.
     * 
     * @param posicion posición donde insertar
     * @param valor valor a insertar
     */
    void insertarEnLaPosicion(int posicion, int valor);

    /**
     * Elimina el primer elemento de la lista.
     */
    void eliminarLaPrimera();

    /**
     * Elimina el último elemento de la lista.
     */
    void eliminarLaUltima();

    /**
     * Elimina el elemento de una posición concreta.
     * 
     * @param posicion posición a eliminar
     */
    void eliminar(int posicion);

    /**
     * Busca un número en la lista.
     * 
     * @param n número a buscar
     * @return posición del número o -1 si no existe
     */
    int buscar(int n);

    /**
     * Une la lista actual con otra lista.
     * 
     * @param lista2 lista a unir
     */
    void unirDosListas(Lista lista2);

    /**
     * Devuelve una representación en texto de la lista.
     * 
     * @return contenido de la lista
     */
    String imprimirLista();
}

