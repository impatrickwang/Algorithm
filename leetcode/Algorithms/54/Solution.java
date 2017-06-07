public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length < 1 || matrix[0].length < 1) return res;
        int x = 0;
        int m = matrix[0].length-1;
        int n = matrix.length-1;
        while (m >= 0 && n >= 0) {
            if (m == 0 && n ==0) { 
                res.add(matrix[x][x]); 
            } else if (m == 0) {
                for (int i = 0; i <= n; i++) res.add(matrix[x+i][x]);
            } else if (n == 0) {
                for (int i = 0; i <= m; i++) res.add(matrix[x][x+i]);
            } else {
                for (int i = 0; i < m; i++) res.add(matrix[x][x+i]);
                for (int i = 0; i < n; i++) res.add(matrix[x+i][matrix[0].length-1-x]);
                for (int i = 0; i < m; i++) res.add(matrix[matrix.length-1-x][matrix[0].length-1-x-i]);
                for (int i = 0; i < n; i++) res.add(matrix[matrix.length-1-x-i][x]);
            }
            x++;
            m -= 2;
            n -= 2;
        }
        return res;
    }
}
