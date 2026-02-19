import java.util.Scanner;

public class Main {
    static int n,m,r,c;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        map = new int[n][n];
        map[r][c] = 1;
        
        int t=0;
        while (++t<=m) {
            int[][] temp = new int[n][n];
            for (int i=0; i<n; i++) temp[i] = map[i].clone();

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (map[i][j]==1) {
                        for (int d=0; d<4; d++) {
                            int nr = i + t*dr[d];
                            int nc = j + t*dc[d];

                            if (!inRange(nr, nc)) continue;

                            temp[nr][nc] = 1;
                        }
                    }
                }
            }

            map = temp;
        }

        int answer = 0;
        for (int[] arr : map) {
            for (int x : arr) {
                if (x == 1) answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
}