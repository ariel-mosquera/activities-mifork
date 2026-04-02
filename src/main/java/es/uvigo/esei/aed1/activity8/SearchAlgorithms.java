package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    // Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor) throws IndexOutOfBoundsException {
        if (xPosition < 0 || xPosition >= aux.length || yPosition < 0 || yPosition >= aux[0].length)
            throw new IndexOutOfBoundsException("Invalid position");

        int oldColor = aux[xPosition][yPosition];
        // vertical search going down
        int i = xPosition;
        boolean isContiguous = true;
        while (i < aux.length && isContiguous) {
            if (aux[i][yPosition] == oldColor)
                aux[i][yPosition] = newColor;
            else
                isContiguous = false;
            i++;
        }
        // vertical search going up
        i = xPosition - 1;
        isContiguous = true;
        while (i >= 0 && isContiguous) {
            if (aux[i][yPosition] == oldColor)
                aux[i][yPosition] = newColor;
            else
                isContiguous = false;
            i--;
        }
        // horizontal search going right
        i = yPosition + 1;
        isContiguous = true;
        while (i < aux[0].length && isContiguous) {
            if (aux[xPosition][i] == oldColor)
                aux[xPosition][i] = newColor;
            else
                isContiguous = false;
            i++;
        }
        // horizontal search going left
        i = yPosition - 1;
        isContiguous = true;
        while (i >= 0 && isContiguous) {
            if (aux[xPosition][i] == oldColor)
                aux[xPosition][i] = newColor;
            else
                isContiguous = false;
            i--;
        }
    }

    // Exercise 2
    public static boolean isMagicSquare(int[][] board, int magicConstant) {

        return true;

    }

    // Exercise 3
    public static int howManyMinors(int[] aux, int elem) {

        return -1;
    }

    // Exercise 4
    public static int howManyOlder(int[] aux, int elem) {

        return -1;
    }

    // Exercise 5
    public static int containNumber(int[] array, int beginning, int fin) {
        return -1;
    }

    // Exercise 6
    public static int searchInsertionDec(int[] aux, int elem, int max) {
        return -1;

    }

}
