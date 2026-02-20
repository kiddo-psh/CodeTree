import java.util.Scanner;

class Pair{
    int r, c;
    public Pair(int r, int c) {this.r=r; this.c=c;}
}

public class Main {
    static final int[] dr = {-1,0,1,-1,1,-1,0,1};
    static final int[] dc = {-1,-1,-1,0,0,1,1,1};

    static int n;
    static int[][] grid;

    static boolean inRange (int r , int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    static Pair findPos(int num) {
        for (int i=0; i<n; i++) for (int j=0; j<n; j++)
        if (grid[i][j]==num) return new Pair(i,j);

        return new Pair(0,0);
    }

    static Pair findBig(Pair pos) {
        int r = pos.r;
        int c = pos.c;

        int maxVal = 0;
        Pair maxPos = new Pair(0,0);

        for (int d=0; d<8; d++) {
            int nr = r +dr[d], nc = c +dc[d];
            if (inRange(nr, nc) && grid[nr][nc]>maxVal) {
                maxVal = grid[nr][nc];
                maxPos = new Pair(nr,nc);
            }
        }

        return maxPos;
    }

    static void swap(Pair pos, Pair next) {
        int temp = grid[pos.r][pos.c];
        grid[pos.r][pos.c] = grid[next.r][next.c];
        grid[next.r][next.c] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i=0; i<m; i++) {
            turn();
        }

        for (int[] arr: grid) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void turn() {
        for (int num=1; num<=n*n; num++) {
            Pair pos = findPos(num);
            Pair next = findBig(pos);
            swap(pos, next);
        }
    }
}