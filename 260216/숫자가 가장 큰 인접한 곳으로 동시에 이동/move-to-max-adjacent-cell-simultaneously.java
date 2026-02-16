import java.util.Scanner;
public class Main {
    static int n, m, t;
    static int[][] grid;
    static int[][] next;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        grid = new int[n][n];
        next = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            next[sc.nextInt()-1][sc.nextInt()-1] = 1;
        }

        while (t-->0) {
            move();
        }
        
        int ans = 0;
        for (int[] arr : next) {
            for (int x : arr) {
                if (x == 1) ans++;
            }
        }
        System.out.println(ans);
    }

    static void move() {
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (next[i][j]==1) {
                    int max = 0;
                    for (int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!inRange(nr, nc)) continue;
                        
                        max = Math.max(max, grid[nr][nc]);
                    }
                    for (int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!inRange(nr, nc)) continue;
                        if (grid[nr][nc] == max) {
                            temp[nr][nc]++;
                            break;
                        }
                    }
                    
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (temp[i][j]>=2) {
                    temp[i][j]=0;
                }
            }
        }
        
        next = temp;
    }
    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
}