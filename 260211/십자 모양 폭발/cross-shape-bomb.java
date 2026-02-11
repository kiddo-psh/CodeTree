import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        boom(r-1,c-1);

        for (int g[] : grid) {
            for (int x : g) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void gravity() {
        int[][] temp = new int[n][n];
        for (int c=0; c<n; c++) {
            int rowIdx = n-1;
            for (int r=n-1; r>=0; r--) {
                if (grid[r][c] == 0) continue;
                temp[rowIdx--][c] = grid[r][c];
            }
        }
        grid = temp;
    }

    static void boom(int r, int c) {
        int len = grid[r][c];
        for (int d=0; d<4; d++) {
            for (int i=0; i<len; i++) {
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;
                if (!inRange(nr, nc)) break;
                grid[nr][nc] = 0;
            }
        }
        gravity();
    } 

    static boolean inRange (int r, int c) {
        return r>=0 && c>=0 && r<n && c<n;
    }

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
}