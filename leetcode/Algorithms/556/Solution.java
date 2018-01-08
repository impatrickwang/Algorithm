class Solution {
    public int nextGreaterElement(int n) {
        int[] arr = new int[12];
        int l = 0;
        long m = n;
        while (m > 0) {
            if (l == 0 || m % 10 >= arr[l-1]) arr[l++] = m % 10;
            else break;
            m /= 10;
        }
        if (m <= 0) return -1;
        int c = l-1;
        while (c > 0 && arr[c-1] > m % 10) {
            c--;
        }
        int tmp = m % 10;
        m += arr[c]-tmp;
        arr[c] = tmp;
        for (int i = 0; i < l; i++) m = m * 10 + arr[i];
        if (m > Integer.MAX_VALUE) return -1;
        return (int) m;
    }
}
