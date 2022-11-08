package testpackage;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
       int xx=55;

        int[][] arrayWithGlider= new int[25][25];
        for(int i=0;i<arrayWithGlider.length;i++){
            Arrays.fill(arrayWithGlider[i],0);
        }

        arrayWithGlider[11][10]=1;
        arrayWithGlider[11][11]=1;
        arrayWithGlider[11][12]=1;
        arrayWithGlider[10][12]=1;
        arrayWithGlider[9][11]=1;

        while(xx-->0){
            printArr(arrayWithGlider);
            gameOfLife(arrayWithGlider);
        }

        printArr(arrayWithGlider);
    }

    public static void gameOfLife(int[][] matrix) {

        int length = matrix.length;
        int breadth = matrix[0].length;

        int[][] nextGen = new int[length][breadth];
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {

                int noOfNeighbours = checkLivingNeighbours(matrix, i, j, length - 1, breadth - 1);

                //System.out.println("neighbours["+i+"]["+j+"] :"+noOfNeighbours);
                int whatMI = matrix[i][j];

                if (whatMI == 1 && (noOfNeighbours < 2 || noOfNeighbours > 3)) {
                    nextGen[i][j] = 0;
                } else if (whatMI == 0 && noOfNeighbours == 3) {
                    nextGen[i][j] = 1;
                } else {
                    nextGen[i][j] = whatMI;
                }

            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                matrix[i][j] = nextGen[i][j];
            }
        }
    }


    private static int checkLivingNeighbours(int[][] arr, int x, int y, int xBound, int yBound) {

        int noOfLivingNeighbours = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((x == 0 && i == -1) || (y == 0 && j == -1)
                        || (x == xBound && i == 1) || (y == yBound && j == 1)) {
                    continue;
                }
                noOfLivingNeighbours += arr[x + i][y + j];
            }
        }
        noOfLivingNeighbours -= arr[x][y];

        return noOfLivingNeighbours;
    }

    private static void printArr(int[][] aa){
        for (int i = 0; i < aa.length; i++) {
            System.out.println("");
            for (int j = 0; j < aa[i].length; j++) {
                System.out.print(aa[i][j]==0 ? " ":"1");
                if(j!=aa[i].length-1)
                    System.out.print(",");

            }
        }
    }
}

