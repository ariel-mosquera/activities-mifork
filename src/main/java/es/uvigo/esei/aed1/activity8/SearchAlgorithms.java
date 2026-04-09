package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    // Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor) throws IndexOutOfBoundsException {
        if (xPosition < 0 || xPosition >= aux.length || yPosition < 0 || yPosition >= aux[0].length)
            throw new IndexOutOfBoundsException("Invalid position");

        if (aux[xPosition][yPosition] == newColor)
            return;

        int oldColor = aux[xPosition][yPosition];
        int x = xPosition;
        int y = yPosition;

        // vertical search going down
        while (x < aux.length && aux[x][y] == oldColor)
            aux[x++][y] = newColor;

        // vertical search going up
        x = xPosition - 1;
        while (x >= 0 && aux[x][y] == oldColor)
            aux[x--][yPosition] = newColor;

        // horizontal search going right
        x = xPosition;
        y = yPosition + 1;
        while (y < aux[0].length && aux[x][y] == oldColor)
            aux[x][y++] = newColor;

        // horizontal search going left
        y = yPosition - 1;
        while (y >= 0 && aux[x][y] == oldColor)
            aux[xPosition][y--] = newColor;
    }

    // Exercise 2
    public static boolean isMagicSquare(int[][] board, int magicConstant) {
        int size = board.length;

        for (int i = 1; i <= size * size; i++) {
            int row = 0;
            int col = 0;
            boolean found = false;

            while (row < board.length && !found) {
                while (col < board[0].length && !found) {
                    if (board[row][col] == i)
                        found = true;

                    col++;
                }
                row++;
                col = 0;
            }

            if (!found)
                return false;
        }

        int sumRow = 0;
        int sumCol = 0;

        for (int i = 0; i < size; i++) {
            sumRow = 0;
            sumCol = 0;

            for (int j = 0; j < size; j++) {
                sumRow += board[i][j];
                sumCol += board[j][i];
            }

            if (sumRow != magicConstant || sumCol != magicConstant)
                return false;
        }

        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;

        for (int i = 0; i < size; i++) {
            sumDiagonal1 += board[i][i];
            sumDiagonal2 += board[i][size - 1 - i];
        }

        if (sumDiagonal1 != magicConstant || sumDiagonal2 != magicConstant)
            return false;

        return true;

    }

    // Exercise 3
    public static int howManyMinors(int[] aux, int elem) {
        int start = 0;
        int end = aux.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (aux[middle] > elem)
                end = middle - 1;
            else if (aux[middle] < elem)
                start = middle + 1;
            else
                end = middle - 1;
        }

        return start;
    }

    // Exercise 4
    public static int howManyOlder(int[] aux, int elem) {
        int start = 0;
        int end = aux.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (aux[middle] > elem)
                end = middle - 1;
            else if (aux[middle] < elem)
                start = middle + 1;
            else
                start = middle + 1;
        }

        return aux.length - start;
    }

    // Exercise 5
    public static int containNumber(int[] array, int beginning, int end) {
        if (beginning > end)
            return -1;

        int middle = (beginning + end) / 2;

        if (array[middle] > middle)
            return containNumber(array, beginning, middle - 1);
        if (array[middle] < middle)
            return containNumber(array, middle + 1, end);
        else
            return middle;
    }

    // Exercise 6
    public static int searchInsertionDec(int[] aux, int elem, int max) {
        return -1;

    }

}
