class Solution {
    public boolean isPowerOfFour(int num) {
        return num & 0xaaaaaaaa == 0 && countOne(num) == 1;
    }

    private int countOne(int num) {
        num = (num & 0x33333333) + ((num & 0xcccccccc) >> 2);
        num = (num & 0x0f0f0f0f) + ((num & 0xf0f0f0f0) >> 4);
        num = (num & 0x00ff00ff) + ((num & 0xff00ff00) >> 8);
        num = (num & 0x0000ffff) + ((num & 0xffff0000) >> 16);
        return num;
    }
}
