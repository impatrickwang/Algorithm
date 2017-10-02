class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) return false;
        return search(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }
    
    private boolean search(int[][] matrix, int rs, int re, int cs, int ce, int target) {
        if (cs > ce || rs > re) return false;
        if (rs == re && cs == ce) return matrix[rs][cs] == target;
        int cm = (cs+ce)/2;
        int rm = (rs+re)/2;
        if (matrix[rm][cm] == target) return false;
        if (matrix[rm][cm] > target) {
            if (rs == re) return search(matrix, rs, re, cs, cm-1, target);
            if (cs == ce) return search(matrix, rs, rm-1, cs, ce, target);
            return search(matrix, rs, rm-1, cs, cm-1, target) || search(matrix, rm, re, cs, cm-1, target) || search(matrix, rs, rm-1, cm, ce, target);
        }
        if (rs == re) return search(matrix, rs, re, cm+1, ce, target);
        if (cs == ce) return search(matrix, rm+1, re, cs, ce, target);
        return search(matrix, rs, rm, cm+1, ce, target) || search(matrix, rm+1, re, cs, cm, target) || search(matrix, rm+1, re, cm+1, ce, target);
    }
}
