import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;

            if (!visited[r][c]) 
                bfs(r, c);
        }

        System.out.println(count);
        
    }

    static void bfs(int r, int c) {
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        count++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(canGo(nr, nc)) {
                    count++;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static int n, k, count;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static boolean canGo(int r, int c) {
        return inRange(r,c) && !visited[r][c] && grid[r][c]==0;
    }
}