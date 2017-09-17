class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (!s.contains(n) && n != 1) {
            s.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
