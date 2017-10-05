class Solution {
    public int countDigitOne(int n) {
        if (n < 1) return 0;
        long dividen = 10;
        long index = 1;
        long cnt = 1;
        long sum = 0;
        while (n >= index) {
            long q = n / dividen;
            long r = n % dividen;
            sum += q*cnt;
            sum += r < index ? 0 : (r >= index+cnt ? cnt : r-index+1);
            dividen *= 10;
            cnt *= 10;
            index *= 10;
        }
        return (int) sum;
    }
}
