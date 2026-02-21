
package es.uvigo.esei.aed1.activity0.exercise16;

import java.util.Scanner;

public class Activity0Exercise16 {

  // exercise 16

  /**
   * Calcula el maximo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int maximum(int[] array) {
    var max = array[0];

    for (int i = 0; i < array.length; i++) {
      if (max < array[i])
        max = array[i];
    }

    return max;
  }

  /**
   * Calcula el mínimo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int minimum(int[] array) {
    var min = array[0];

    for (int i = 0; i < array.length; i++) {
      if (array[i] < min)
        min = array[i];
    }

    return min;
  }

  /**
   * Calcula el promedio de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor promedio
   */
  public static double average(int[] array) {
    var suma = 0;

    for (int i = 0; i < array.length; i++) {
      suma += array[i];
    }

    return (double) suma / array.length;
  }

  public static int readInteger(String message) {
    var teclado = new Scanner(System.in);

    System.out.print("\n" + message);
    int num = Integer.parseInt(teclado.nextLine());
    teclado.close();

    return num;
  }

  /**
   * almacena enteros en el array haciendo uso del método readInteger
   * 
   * @param array que almacenará los enteros
   */
  public static void readArray(int[] array) {

    for (int i = 0; i < array.length; i++) {
      System.out.println("Indice [" + i + "]");
      array[i] = readInteger("Introduce un entero: ");
    }

  }

}
