class Solution {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int cnt = 0;
        for (int i = 0; i < secret.length(); i++) {
            s[secret.charAt(i)-'0']++;
            g[guess.charAt(i)-'0']++;
            if (secret.charAt(i) == guess.charAt(i)) cnt++;
        }
        int t = 0;
        for (int i = 0; i < 10; i++) t += Math.min(s[i], g[i]);
        return cnt+"A"+(t-cnt)+"B";
    }
}
