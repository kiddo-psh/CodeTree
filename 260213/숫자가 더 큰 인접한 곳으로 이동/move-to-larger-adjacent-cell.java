import java.util.Scanner;
public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            System.out.print(grid[r][c] + " ");
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                //System.out.println("nr="+nr + ",  nc="+nc);
                if (!inRange(nr, nc)) continue;
                if (grid[nr][nc] > grid[r][c]) {
                    flag = true;
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }
        
    }

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static boolean inRange(int r, int c) {
        return r>=1 && r<=n && c>=1 && c<=n;
    }
}