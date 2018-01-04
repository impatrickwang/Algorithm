class Solution {
    public int findComplement(int num) {
        int mask = Integer.MIN_VALUE;
        while ((mask & num) == 0) {
            mask = mask >>> 1;
        }
        while (mask != 0) {
            num = num ^ mask;
            mask = mask >>> 1;
        }
        return num;
    }
}
