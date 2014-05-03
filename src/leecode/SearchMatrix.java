package leecode;

import java.util.Arrays;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] head = new int[matrix.length];
        for (int i = 0; i < head.length; i++) {
            head[i] = matrix[i][0];
        }

        int index = Arrays.binarySearch(head, target);
        if (index >= 0) {
            return true;
        }

        index = -(index + 1);

        if (index > 0) {
            return Arrays.binarySearch(matrix[index - 1], target) >= 0;
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrix c = new SearchMatrix();

        int[][] matrix = new int[][] { { 1, 2, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        int target = 3;

        boolean ret = c.searchMatrix(matrix, target);

        System.out.println(ret);
    }

}
