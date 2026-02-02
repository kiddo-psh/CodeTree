import java.util.Scanner;

public class Main {
    static int[] x;
    static int[] y;
    static int n;
    static int result = Integer.MAX_VALUE;

    static void dfs(int prev, int cur, int sum, int jump){
        if (cur == n && jump == 1) {
            result = Math.min(result, sum);
        }
        if (jump > 1 || cur >= n) return;

        int d = Math.abs(x[prev]-x[cur]) + Math.abs(y[prev]-y[cur]);
        dfs(cur, cur+1, sum+d, jump);
        dfs(cur, cur+2, sum+d, jump+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        dfs(0, 0, 0, 0);

        System.out.println(result);
    }
}