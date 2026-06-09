package es.uvigo.esei.aed1.activity8.pellets;

public class SearchPellets {

    // Exercise 7
    public static int searchPellets(int[][] galicianCoastMatrix, Position beginning, Position end) {
        int counter = 0;

        for (int i = beginning.getX(); i <= end.getX(); i++) {
            for (int j = beginning.getY(); j <= end.getY(); j++) {
                if (galicianCoastMatrix[i][j] == 0)
                    counter++;
            }
        }

        return counter;
    }
}
