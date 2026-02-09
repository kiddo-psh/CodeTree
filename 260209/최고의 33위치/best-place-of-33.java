import java.util.Scanner;
public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for (int i=0; i<=n-3; i++) {
            for (int j=0; j<=n-3; j++) {
                int sum = calc(i, j);
                result = Math.max(sum, result);
            }
        }

        System.out.println(result);
        // Please write your code here.
    }
    static int calc (int r, int c) {
        int ret = 0;
        for (int i=r; i<r+3; i++) {
            for (int j=c; j<c+3; j++) {
                ret += grid[i][j];
            }
        }
        return ret;
    }
}