package sebastin;

import java.util.Arrays;

/**
 * Created by sebastin on 8/17/17.
 *
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    private static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("-----------------");
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    //from book
    private static int[][] rotateMatrix(int[][] matrix) {

        if (matrix.length== 0 || matrix.length != matrix[0].length) {
            return new int[2][2];
        }
        int n = matrix.length;
        for (int layer=0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i=layer; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                //left - top
                matrix[first][i] = matrix[last-offset][first];
                //bottom - left
                matrix[last-offset][first] = matrix[last][last-offset];
                //right - bottom
                matrix[last][last-offset] = matrix[i][last];
                //top - right
                matrix[i][last] = top;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,2}, {3,4}};
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        printMatrix(matrix);
        System.out.println("-----------------------");
        System.out.println(Arrays.deepToString(rotateMatrix(matrix)));
        System.out.println(Arrays.deepToString(rotateMatrix(matrix1)));
    }
}
