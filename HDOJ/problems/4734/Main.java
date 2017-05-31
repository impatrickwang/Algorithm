import java.util.Scanner;

public class Main {
    
    private static int[][] dp = new int[10][5000];
    private static int[] d; 
    private static int all;

    public static void main (String[] args) {
        for (int i = 0; i < 10; i++) for (int j = 0; j < 5000; j++) dp[i][j] = -1;
        Scanner sca = new Scanner(System.in);
        int T = sca.nextInt();
        for (int t = 0; t < T; t++) {
            int a = sca.nextInt();
            int b = sca.nextInt();
            f(a);
            // System.out.println("a: "+a+" b: "+b);
            System.out.println("Case #"+(t+1)+": "+solve(b));
        }
    }

    private static void f(int a) {
        int w = 1;
        all = 0;
        while (a > 0) {
            all += (a % 10) * w;
            w *= 2;
            a /= 10;
        }
        // System.out.println("all: "+all);
    }

    private static int solve(int b) {
        d = new int[10];
        int pos = 0;
        while (b > 0) {
            d[pos++] = b % 10;
            b /= 10;
        }
        return dfs(pos-1, 0, true);
    }

    private static int dfs(int pos, int status, boolean limit) {
        // System.out.println("pos: "+pos+" status: "+status+" limit: "+limit);
        if (pos < 0) {
            if (status <= all) return 1;
            return 0;
        }
        if (status > all) return 0;
        if (!limit && dp[pos][all-status] >= 0) return dp[pos][all-status];
        int up = limit ? d[pos] : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) 
            res += dfs(pos-1, status+i*(1<<pos), limit && i == up);
        if (!limit) dp[pos][all-status] = res;
        // System.out.println("pos: "+pos+" status: "+status+" limit: "+limit+" res: "+res);
        return res;
    }
}
