import java.util.Scanner;
public class Main {

    static final int[] dr = {-1, -1, 1, 1};
    static final int[] dc = {-1, 1, 1, -1};

    static int[][] grid;
    static int n, result, sum;
    static int tr, tc;

    static void dfs (int r, int c, int dir, int s) {
        if (dir==3 && r==tr && c==tc) {
            sum = Math.max(s, sum);
            return;
        }
        if (r > tr) return;
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (inRange(nr, nc))
            dfs (nr, nc, dir, s+grid[nr][nc]); // 방향 전환 없을 때.

        if (dir!=3) {
            nr = r + dr[dir+1];
            nc = c + dc[dir+1];
            if (inRange(nr, nc))
                dfs(nr, nc, dir+1, s+grid[nr][nc]);
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i=2; i<n; i++) {
            for (int j=1; j<n-1; j++) {
                tr = i; tc = j;
                sum = 0;
                dfs(i, j, 0, 0);
                result = Math.max(result, sum);
            }
        }

        System.out.println(result);
    }
}