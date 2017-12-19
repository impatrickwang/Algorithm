class Solution {
    public int findNthDigit(int n) {
        int w = 1;
        long cnt = 9;
        long start = 1;
        long sum = 9;
        while (n > sum) {
            w++;
            cnt = cnt*10;
            sum += cnt*w;
            start *= 10;
        }
        sum -= cnt*w;
        long offset = (n-1-sum) / w;
        long remain = w - (n-1-sum) % w;
        long target = start + offset;
        long res = 0;
        while (remain > 0) {
            res = target % 10;
            target /= 10;
            remain--;
        }
        return (int) res;
    }
}
