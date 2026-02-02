import java.util.Scanner;
public class Main {
    static char[][] grid;
    static int result = 0;
    static int R, C;
    static void dfs(int r, int c, int jump) {
        if (jump == 2) {
            result++;
            return;
        }

        for (int i=r+1; i<R-2+jump; i++) {
            for (int j=c+1; j<C-2+jump; ++) {
                if (grid[r][c] != grid[i][j]) {
                    dfs(i,j,jump+1);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        dfs(0, 0, 0);

        System.out.println(result);
    }
}