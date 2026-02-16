import java.util.*;
public class Main {
    static int n, m, cnt, ans;
    static int[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        ans = 1;
        while(bfs()){
            ans++;
        }

        System.out.println(ans + " " + cnt);

    }

    static boolean bfs() {
        visitedClear();
        q.clear();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!inRange(nr, nc)) continue;
                if (grid[nr][nc]==1) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});

            }
        }
        cnt = 0;
        for (int i=1; i<n-1; i++) {
            for (int j=1; j<m-1; j++) {
                if (grid[i][j]==0) continue;

                for (int d=0; d<4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (!inRange(nr, nc)) continue;
                    if (grid[nr][nc]==1) continue;
                    if (visited[nr][nc]) {
                        cnt++;
                        grid[i][j] = 0;
                        break;
                    }
                }
            }
        }
        
        for (int[] arr : grid) {
            for (int x : arr) {
                if (x == 1) return true;
            }
        }
        return false;
    }

    static void visitedClear() {
        for (int i=0; i<n; i++) for (int j=0; j<m; j++)
            visited[i][j] = false;
    }

    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    static Queue<int[]> q = new LinkedList<>();

    static boolean inRange (int r, int c) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}