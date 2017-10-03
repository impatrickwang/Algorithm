class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        if (l < 1) return 0;
        if (l < 2) return 1;
        int[] up = new int[l];
        int[] down = new int[l];
        for (int i = 0; i < l; i++) {
            if (i == 0) {
                if (ratings[i+1] >= ratings[i]) up[i] = 1;
                if (ratings[l-i-2] >= ratings[l-i-1]) down[l-1-i] = 1;
            } else if (i == l-1) {
                if (ratings[i] > ratings[i-1]) up[i] = up[i-1]+1;
                if (ratings[l-1-i] > ratings[l-i]) down[l-1-i] = down[l-i]+1;
            } else {
                if (ratings[i-1] < ratings[i]) up[i] = up[i-1]+1;
                else up[i] = 1;
                if (ratings[l-i] < ratings[l-i-1]) down[l-i-1] = down[l-i]+1;
                else down[l-1-i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < l; i++) sum += Math.max(up[i], down[i]);
        return sum;
    }
}
