public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       	int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        int l = 0;
        int h = m*n-1;
        while (l <= h) {
            int mid = (l+h)/2;
            if (matrix[mid/n][mid%n] == target) return true;
            if (matrix[mid/n][mid%n] < target) l = mid+1;
            else h = mid-1;
        }
        return false; 
    }
}
