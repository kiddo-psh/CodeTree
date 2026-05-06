import java.util.*;
import java.io.*;

public class Main {

    static int N, max;
    static int[][] grid, dir;

    static final int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

    static void dfs(int r, int c, int cnt) {
        boolean flag = false;

        int d = dir[r][c];
        int n = grid[r][c];

        for (int i=0; i<N; i++) {
            int nr = r + i*dr[d];
            int nc = c + i*dc[d];

            if (!inRange(nr, nc)) break;
            if (grid[nr][nc] <= n) continue;

            flag = true;
            dfs(nr, nc, cnt+1);
        }

        if (!flag) {
            max = Math.max(max, cnt);
            return;
        }
    }   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dir = new int[N][N];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                dir[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;

        max = 0;
        dfs(sr, sc, 0);
        System.out.println(max);
    }
}