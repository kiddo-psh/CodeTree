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

        int result = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                result = Math.max(boom(r,c), result);
            }
        }       
        System.out.println(result);
    }

    static int boom(int r, int c) {
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++) temp[i] = grid[i].clone();

        int len = temp[r][c];
        
        for (int i=0; i<len; i++) {
            for (int d=0; d<4; d++) {
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;

                if (!inRange(nr, nc)) continue;

                temp[nr][nc] = 0;
            }
        }

        temp = gravity(temp);
        return count(temp);
    }

    static int[][] gravity(int[][] grid) {
        int[][] temp = new int[n][n];

        for (int col=0; col<n; col++) {
            int rIndex = n-1;
            for (int row=n-1; row>=0; row--) {
                if (grid[row][col] == 0) continue;
                temp[rIndex--][col] = grid[row][col];
            }
        }

        return temp;
    }

    static int count(int[][] temp) {
        int ret = 0;

        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                for (int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!inRange(nr, nc)) continue;
                    if (temp[r][c] == 0 || temp[nr][nc] == 0) continue;
                    if (temp[nr][nc] == temp[r][c]) ret++;
                }
            }
        }
        return ret/2;
    }

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }
}