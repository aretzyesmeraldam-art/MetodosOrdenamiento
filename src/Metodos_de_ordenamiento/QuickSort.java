package Metodos_de_ordenamiento;

/**
 * Clase que implementa el algoritmo de ordenamiento QuickSort.
 * Utiliza la estrategia Divide y Venceras seleccionando un pivote y particionando
 * el arreglo en subarreglos de elementos menores y mayores al pivote.
 */
public class QuickSort {

    /**
     * Metodo principal recursivo que ordena el arreglo entre los indices bajo y alto.
     */
    public static void ordenar(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            // Encuentra el indice de particion; arr[pi] queda en su posicion final
            int pi = particion(arr, bajo, alto);

            // Ordena recursivamente los elementos antes y despues de la particion
            ordenar(arr, bajo, pi - 1);
            ordenar(arr, pi + 1, alto);
        }
    }

    /**
     * Toma el ultimo elemento como pivote, lo coloca en su posicion correcta
     * en el arreglo ordenado y ubica los menores a su izquierda y los mayores a su derecha.
     */
    private static int particion(int[] arr, int bajo, int alto) {
        int pivote = arr[alto];
        int i = (bajo - 1); // Indice del elemento mas pequeno

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivote) {
                i++;
                // Intercambio arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Colocar el pivote en su posicion definitiva
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] datos = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("=== ORDENAMIENTO QUICKSORT ===");
        System.out.print("Arreglo original: ");
        imprimirArreglo(datos);

        ordenar(datos, 0, datos.length - 1);

        System.out.print("Arreglo ordenado: ");
        imprimirArreglo(datos);
    }
}