public class Solution {
	// 23:26
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] l = new int[prices.length+1];
        int[] r = new int[prices.length+1];
        int lmin = prices[0];
        int rmax = prices[prices.length-1];
        for (int i = 2; i <= prices.length; i++) {
            l[i] = Math.max(l[i-1], prices[i-1]-lmin);
            lmin = Math.min(lmin, prices[i-1]);
            r[i] = Math.max(r[i-1], rmax-prices[prices.length-i]);
            rmax = Math.max(rmax, prices[prices.length-i]);
        }
        int res = 0;
        for (int i = 0; i <= prices.length; i++) {
            res = Math.max(res, l[i] + r[prices.length-i]);
        }
        return res;
    }
}
