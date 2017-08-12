public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] args1 = version1.split("\\.");
        String[] args2 = version2.split("\\.");
        int i = 0;
        while (i < args1.length && i < args2.length) {
            int c = compare(args1[i], args2[i]);
            if (c != 0) return c;
            i++;
        }
        while (i < args1.length && isZero(args1[i]) || i < args2.length && isZero(args2[i])) {
            i++;
        }
        if (i < args1.length) return 1;
        if (i < args2.length) return -1;
        return 0;
    }

    private int compare(String s, String p) {
        int so = 0;
        while (so < s.length() && s.charAt(so) == '0') {
            so++;
        }
        int po = 0;
        while (po < p.length() && p.charAt(po) == '0') {
            po++;
        }
        if (s.length() - so > p.length() - po) return 1;
        if (s.length() - so < p.length() - po) return -1;
        int i = 0;
        while (i+so < s.length() && i+po < p.length()) {
            if (s.charAt(i+so) < p.charAt(i+po)) return -1;
            if (s.charAt(i+so) > p.charAt(i+po)) return 1;
            i++;
        }
        return 0;
    }

    private boolean isZero(String s) {
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != '0') return false;
        return true;
    }
}
