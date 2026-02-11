import java.util.Scanner;
public class Main {
    static int[][] building;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        
        for (int i = 0; i < q; i++){
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();
                wind (r1-1, c1-1, r2-1, c2-1);
            }
                
        for (int[] b : building) {
            for (int x : b) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void wind (int r1, int c1, int r2, int c2) {
        int tempUp = building[r1][c2];
        int tempDown = building[r2][c1];
        for (int i=c2-1; i>=c1; i--) {
            building[r1][i+1] = building[r1][i];
        }
        for (int i=c1; i<c2; i++) {
            building[r2][i] = building[r2][i+1];
        }
        for (int i=r2; i>r1; i--) {
            building[i][c2] = building[i-1][c2];
        }
        for (int i=r1; i<r2; i++) {
            building[i][c1] = building[i+1][c1];
        }
        building[r1+1][c2] = tempUp;
        building[r2-1][c1] = tempDown;

        modify(r1, c1, r2, c2);
    }

    static void modify(int r1, int c1, int r2, int c2) {
        int[][] mod = new int[r2-r1+1][c2-c1+1];
        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                int count = 1;
                int sum = building[r][c];
                for (int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (!inRange(nr, nc)) continue;

                    sum += building[nr][nc];
                    count++;
                }
                mod[r-r1][c-c1] = sum/count;
            }
        }
        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                building[r][c] = mod[r-r1][c-c1];
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && c>=0 && r<n && c<m;
    }

    static int n, m;
    static final int[] dr = new int[] {-1,1,0,0};
    static final int[] dc = new int[] {0,0,-1,1};
}