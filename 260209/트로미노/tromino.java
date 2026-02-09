import java.util.Scanner;

public class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<=n-2; i++) {
            for (int j=0; j<=m-2; j++) {
                int sum = 0;
                for (int k=i; k<i+2; k++) {
                    for (int l=j; l<j+2; l++) {
                        sum += grid[k][l];
                    }
                }
                result = Math.max(result, sum-grid[i][j]);
                result = Math.max(result, sum-grid[i+1][j]);
                result = Math.max(result, sum-grid[i][j+1]);
                result = Math.max(result, sum-grid[i+1][j+1]);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<=m-3; j++) {
                int sum = 0;
                for (int k=j; k<j+3; k++) {
                    sum += grid[i][k];
                }
                result = Math.max(result, sum);
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<=n-3; j++) {
                int sum = 0;
                for (int k=j; k<j+3; k++) {
                    sum += grid[k][i];
                }
                result = Math.max(result, sum);
            }
        }

        System.out.println(result)
    }
}