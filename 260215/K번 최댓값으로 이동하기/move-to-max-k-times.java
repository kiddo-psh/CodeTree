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

        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        q.offer(new int[]{r, c});
        maxVal = 0;
        row = r;
        col = c;

        while (k-- > 0) {
            for(int i=0; i<n; i++) for (int j=0; j<n; j++)
                visited[i][j] = false;
            maxVal = 0;
            bfs();
        }

        System.out.println((row+1) + " " +(col+1));
    }

    static int n, k, count;
    static int maxVal, row, col;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();


    static final int[] dr = {0, 1, -1, 0};
    static final int[] dc = {-1, 0, 0, 1};

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static void bfs() {
        int T = grid[row][col];
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!inRange(nr,nc)) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] >= T) continue;

                if (grid[nr][nc] > maxVal) {
                    row = nr;
                    col = nc;
                    maxVal = grid[nr][nc];
                }
                if (grid[nr][nc] == maxVal) {
                    if (nr < row || (nr==row && nc<col)) {
                        row = nr;
                        col = nc;
                        maxVal = grid[nr][nc];
                    }
                }

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        q.offer(new int[]{row, col});
    }

    /*
    사방탐색하면서 최대값 찾기
    최대값+좌표 저장 후 리턴
    해당 좌표에서 다시 bfs 시작
    */
}