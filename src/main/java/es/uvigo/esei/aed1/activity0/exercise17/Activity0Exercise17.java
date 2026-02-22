
package es.uvigo.esei.aed1.activity0.exercise17;

import java.util.Scanner;

public class Activity0Exercise17 {

  // exercise 17
  /**
   * muestra un mensaje por pantalla y lee un número entero de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número entero leido de teclado
   */
  public static int readNumber(String message) {
    Scanner teclado = new Scanner(System.in);

    System.out.print("\n" + message);
    var num = Integer.parseInt(teclado.nextLine());
    teclado.close();

    return num;
  }

  /**
   * muestra un mensaje por pantalla y lee un número real de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número real leido de teclado
   */
  public static double readDouble(String message) {
    Scanner teclado = new Scanner(System.in);

    System.out.print("\n" + message);
    var num = Double.parseDouble(teclado.nextLine());
    teclado.close();

    return num;
  }

  /**
   * muestra un mensaje por pantalla y lee una matriz de números reales
   * 
   * @param matrix  que almacena números reales
   * @param message el mensaje a visualizar
   */
  public static void readNotes(double[][] matrix, String message) {
    System.out.println(message);
    for (int i = 0; i < matrix.length; i++) { // ALumnos
      System.out.println("Aluno [" + (i + 1) + "]:");
      for (int j = 0; j < matrix[i].length; j++) { // Asignaturas
        matrix[i][j] = readDouble("Nota de la asignatura [" + (j + 1) + "]: ");
      }
    }
  }

  /**
   * muestra por pantalla un mensaje y el contenido de una matriz de números
   * reales
   * 
   * @param matrix  que almacena numeros reales
   * @param message el mensaje a visualizar
   */
  public static void printNotes(double[][] matrix, String message) {
    System.out.println(message);

    for (int i = 0; i < matrix.length; i++) {
      System.out.println("Alumno [" + (i + 1) + "]: ");
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.println("Nota [" + (j + 1) + "]: " + matrix[i][j] + "\t");
      }
    }
  }
}