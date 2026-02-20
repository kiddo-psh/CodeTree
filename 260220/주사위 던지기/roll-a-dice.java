import java.util.Scanner;

public class Main {
    static int n, r, c;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        
        map = new int[n][n];
        map[r][c] = 6;

        for (int i = 0; i < m; i++) {
            char dir = sc.next().charAt(0);
            roll(dir);
        }
        int answer = 0;
        for (int[] arr : map) {
            for (int x : arr) {
                answer += x;
            }
        }

        System.out.println(answer);
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static void roll(char dir) {
        int d=0;
        if(dir=='U') d=0;
        else if (dir=='D') d=1;
        else if (dir=='L') d=2;
        else if (dir=='R') d=3;

        int nr = r + dr[d];
        int nc = c + dc[d];

        if (!inRange(nr, nc)) return;

        if(dir=='U') turnU();
        else if (dir=='D') turnD();
        else if (dir=='L') turnL();
        else if (dir=='R') turnR();

        map[nr][nc] = dice[5];

        r = nr;
        c = nc;
    }

    static final int[] dr = {-1,1,0,0}; // U D L R
    static final int[] dc = {0,0,-1,1};

    static int[] dice = {1,2,3,4,5,6}; // U, F, R, L, B, D

    static void turnL() {
        int[] temp = new int[6];
        
        temp[0] = dice[2];
        temp[1] = dice[1];
        temp[2] = dice[5];
        temp[3] = dice[0];
        temp[4] = dice[4];
        temp[5] = dice[3];
        
        dice = temp;
    }

    static void turnR() {
        int[] temp = new int[6];

        temp[0] = dice[3];
        temp[1] = dice[1];
        temp[2] = dice[0];
        temp[3] = dice[5];
        temp[4] = dice[4];
        temp[5] = dice[2];

        dice = temp;
    }

    static void turnD() {
        int[] temp = new int[6];

        temp[0] = dice[4];
        temp[1] = dice[0];
        temp[2] = dice[2];
        temp[3] = dice[3];
        temp[4] = dice[5];
        temp[5] = dice[1];

        dice = temp;
    }

    static void turnU() {
        int[] temp = new int[6];

        temp[0] = dice[1];
        temp[1] = dice[5];
        temp[2] = dice[2];
        temp[3] = dice[3];
        temp[4] = dice[0];
        temp[5] = dice[4];

        dice = temp;
    }
}