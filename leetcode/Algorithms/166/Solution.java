public class Solution {
	// 23:02
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        if (n % d == 0) return (n/d)+"";
        if (n < 0) n = -n;
        if (d < 0) d = -d;
        StringBuilder res = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) res.append('-');
        res.append(n/d);
        res.append(".");
        long r = n % d;
        Map<Long, Integer> map = new HashMap<>();
        int pos = res.length();
        while (r != 0) {
            r *= 10;
            if (map.containsKey(r)) {
                res.insert(map.get(r), "(");
                res.append(')');
                break;
            }
            res.append(r/d);
            map.put(r, pos++);
            r %= d;
        }
        return res.toString();
    }
}
