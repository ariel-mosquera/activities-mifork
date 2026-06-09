package es.uvigo.esei.aed1.activity10;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class SortAlgorithms {

    // Exercise 1
    public static void bubbleSort2(int[] aux) {
        boolean swap = true;
        int counter = 0;

        do {
            swap = false;
            int temp;

            for (int i = 0; i < aux.length - i; i++) {
                if (aux[i] > aux[i + 1]) {
                    temp = aux[i + 1];
                    aux[i + 1] = aux[i];
                    aux[i] = temp;
                    swap = true;
                }
            }

            for (int i = aux.length; i > counter++; i--) {
                if (aux[i] < aux[i - 1]) {
                    temp = aux[i - 1];
                    aux[i - 1] = aux[i];
                    aux[i] = temp;
                    swap = true;
                }
            }

        } while (swap);
    }

    // Exercise 2
    public static void shellSort(int[] aux) {

    }

    // Exercise 3
    // Produce: el dígito de número, que está en la posición pasada.
    // Para un numero de tres dígitos, pasada tomará los valores 0, 1 y 2,
    // devolviendo las unidades, decenas o centenas respectivamente.
    private static int index(int number, int iteration) {
        return (number / ((int) Math.pow(10, iteration))) % 10;
    }

    public static void radixSort(int[] numbers) {

    }

    // Exercise 4
    public static void selectionSort(int[] aux) {

    }

    // Exercise 5
    public static void countSortDec(int[] aux) {

    }

    // Exercise 6
    public static void beadSort(int[] aux) {

    }

    // Exercise 7
    private static int searchPositionPivot(int[] aux, int beginning, int fin) {
        int first = aux[beginning];
        int k = beginning + 1;

        while (k <= fin) {
            if (aux[k] > first) {
                return k;
            } else if (aux[k] < first) {
                return beginning;
            } else {
                k++;
            }
        }
        // Si llega al final del array y todos los elementos son iguales, o si sólo hay
        // un elemento
        return -1;
    }

    private static void exchange(int[] aux, int i, int j) {
        if (i != j) {
            int temp = aux[i];
            aux[i] = aux[j];
            aux[j] = temp;
        }
    }

    private static int partition(int[] aux, int beginning, int fin, int pivot) {
        int right = beginning;
        int left = fin - 1; // pivote está en la última posición
        do {
            while (aux[right] < pivot) {
                right++;
            }
            while (aux[left] >= pivot) {
                left--;
            }
            // intercambia los valores de las posiciones derecha e izquierda
            if (right < left) {
                exchange(aux, right, left);
            }
        } while (right <= left);

        return right; // primera posición de la segunda mitad
    }

    public static void quickSort(int[] aux, int beginning, int fin) {

    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] aux, int numOfElem) {
        for (int i = 1; i < numOfElem; i++) {
            int j = i - 1;
            T current = aux[i];

            while (j >= 0 && current.compareTo(aux[j]) < 0)
                aux[j + 1] = aux[j--];

            aux[j + 1] = current;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] aux, int numOfElem) {
        for (int i = 0; i < numOfElem; i++) {
            int smallerPos = i;

            for (int j = i + 1; j < numOfElem; j++) {
                if (aux[j].compareTo(aux[smallerPos]) < 0)
                    smallerPos = j;
            }

            if (smallerPos != i) {
                T temp = aux[i];
                aux[i] = aux[smallerPos];
                aux[smallerPos] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] aux, int numOfElem) {
        boolean isSwap = true;
        int counter = 1;

        while (isSwap && counter < aux.length) {
            isSwap = false;
            for (int i = 1; i <= numOfElem - counter; i++) {
                if (aux[i - 1].compareTo(aux[i]) > 0) {
                    T temp = aux[i];
                    aux[i] = aux[i - 1];
                    aux[i - 1] = temp;
                    isSwap = true;
                }
            }
            counter++;
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, middle + 1, end);
        }
    }

    private static void merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        LinkedList<Integer> aux = new LinkedList<>();

        int i = leftStart;
        int j = rightStart;

        while (i <= leftEnd && j <= rightEnd) {
            if (array[i] < array[j])
                aux.addFirst(array[i++]);
            else
                aux.addFirst(array[j++]);
        }

        while (i <= leftEnd)
            aux.addFirst(array[i++]);

        while (j <= rightEnd)
            aux.addLast(array[j++]);

        for (int k = leftStart; k < rightEnd; k++) {
            array[k] = aux.removeFirst();
        }
    }
}
