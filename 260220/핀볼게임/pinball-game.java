import java.util.Scanner;
public class Main {
    static int n, answer;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for (int i=0; i<n; i++) {
            shoot(n-1, i, 0);
            shoot(0, i, 1);
            shoot(i, n-1, 2);
            shoot(i, 0, 3);
        }

        System.out.println(answer);
    }

    static void shoot(int r, int c, int dir) {
        int count = 1;

        while (inRange(r, c)) {
            r += dr[dir];
            c += dc[dir];

            count++;

            if (!inRange(r, c)) break;

            if (grid[r][c] == 0) continue;
            if (grid[r][c] == 1) {
                if (dir==0) dir=3;
                else if (dir==1) dir=2;
                else if (dir==2) dir=1;
                else if (dir==3) dir=0;
            } else if (grid[r][c]==2) {
                if (dir==0) dir=2;
                else if (dir==1) dir=3;
                else if (dir==2) dir=0;
                else if (dir==3) dir=1;
            }
        }

        answer = Math.max(count, answer);
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    // 1 만났을 때  하->좌 / 좌->하 / 우->상 / 상->우
    // 2 만났을 때  우->하 / 하->우 / 좌->상 / 상->좌

    static final int[] dr = {-1,1,0,0}; // 상/히/좌/우
    static final int[] dc = {0,0,-1,1}; 
}