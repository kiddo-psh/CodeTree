import java.util.Scanner;
public class Main {
    static int n, m, cnt, ans;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
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
        int[][] temp = new int[n][m];
        for (int i=0; i<n; i++) temp[i] = grid[i].clone();
        boolean flag = false;
        cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1) continue;
                    flag = true;
                    for (int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!inRange(nr,nc)) continue;
                        if (grid[nr][nc]==0) flag = false;
                    }

                    if (flag) continue; // 사방이 빙하

                    for (int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!inRange(nr,nc)) continue;

                        temp[nr][nc] = 0;
                    }
                
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1) cnt1++;
                if (temp[i][j]==1) cnt2++;
            }
        }

        cnt = cnt1 - cnt2;
        grid = temp;
        //System.out.println(cnt);
        
        if (cnt2==0) return false;
        return true;
    }

    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    static boolean inRange (int r, int c) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}