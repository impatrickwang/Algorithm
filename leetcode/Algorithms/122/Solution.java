public class Solution {
	// 23:00
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int res = 0;
        int min = prices[0];
        int last = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - min;
            if (last > 0 && p < last) {
                res += last;
                min = prices[i];
                last = 0;
            } else {
                min = Math.min(min, prices[i]);
                last = p;
            }
        }
        res += Math.max(prices[prices.length-1]-min, 0);
        return res;
    }
}
