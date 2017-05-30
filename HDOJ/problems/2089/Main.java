import java.util.Scanner;

public class Main {
    private static int[][] dp = new int[8][2];
    private static int[] a;
    public static void main (String[] args) {
        Scanner sca = new Scanner(System.in);
        for (int i = 0; i < 8; i++) for (int j = 0; j < 2; j++) dp[i][j] = -1;
        while (sca.hasNextLine()) {
            int l = sca.nextInt();
            int h = sca.nextInt();
            // System.out.println("l: "+l+" h: "+h);
            if (l == 0 && h == 0) break;
            System.out.println(solve(h) - solve(l-1));
        }
    }

    private static int solve(int num) {
        a = new int[8];
        int pos = 0;
        while (num > 0) {
            a[pos++] = num % 10;
            num /= 10;
        }
        // System.out.println("pos: "+pos);
        return dfs(pos-1, 0, true);
    }

    private static int dfs(int pos, int status, boolean limit) {
        // System.out.println("pos: "+pos+" status: "+status+" limit: "+limit);
        if (pos < 0) return 1;
        if (!limit && dp[pos][status] >= 1) return dp[pos][status];
        int up = limit ? a[pos] : 9;
        int res = 0;
        for (int i = 0; i <= up; i++)
            if (i != 4 && (status == 0 || i != 2)) res += dfs(pos-1, i==6?1:0, limit&&i==up);
        if (!limit) dp[pos][status] = res;
        // System.out.println("pos: "+pos+" status: "+status+" limit: "+limit+" res: "+res);
        return res;
    }
}
