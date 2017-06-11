public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m < 1) return;
        int n = matrix[0].length;
        boolean[] isZero = new boolean[n];
        for (int i = 0; i < m; i++) {
            boolean hasZero = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!isZero[j]) {
                        for (int k = i-1; k >= 0; k--) matrix[k][j] = 0;
                        isZero[j] = true;
                    }
                    hasZero = true;
                } else if (isZero[j]) matrix[i][j] = 0;
            }
            if (hasZero) for (int j = 0; j < n; j++) matrix[i][j] = 0;
        }
    }
}
