public class Solution {
    public int[][] generateMatrix(int n) {
        int x = 0;
        int m = n-1;
        int i = 1;
        int[][] matrix = new int[n][n];
        while (m >= 0) {
            if (m == 0) matrix[x][x] = i;
            else {
                for (int j = 0; j < m; j++) matrix[x][x+j] = i++;
                for (int j = 0; j < m; j++) matrix[x+j][n-1-x] = i++;
                for (int j = 0; j < m; j++) matrix[n-1-x][n-1-x-j] = i++;
                for (int j = 0; j < m; j++) matrix[n-1-x-j][x] = i++;
            }
            m -= 2;
            x++;
        }
        return matrix;
    }
}
