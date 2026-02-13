import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int c = sc.nextInt()-1; // 시작 행
        int r = sc.nextInt()-1; // 시작 열
        char[][] maze = new char[n][n];
        boolean[][][] visited = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        int dir = 1;
        int time = 0;

        while(true) {
            visited [r][c][dir] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (out(nr, nc)) { // 탈출
                time++;
                System.out.print(time);
                return;
            }

            if (visited[nr][nc][dir]) { // 방문했던 곳
                System.out.print(-1);
                return;
            }

            if (maze[nr][nc] == '#') { // 벽
                dir = ccw(dir);
                continue;
            }

            // 이동
            time++;
            r = nr;
            c = nc;

            if (maze[r+dr[cw(dir)]][c+dc[cw(dir)]] != '#') { // 오른쪽에 벽 없음.
                dir = cw(dir);
            }
        }
        
    }

    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌 clockwise
    static int[] dc = {0, 1, 0, -1};

    static int ccw(int dir) { // counter clock wise 반시계
        return (dir-1<0) ? 3 : dir-1;
    }

    static int cw(int dir) {
        return (dir+1)%4;
    }

    static int n;

    static boolean out(int r, int c) {
        return r>=n || r<0 || c>=n || c<0;
    } 
}