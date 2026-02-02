import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int result = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n-2; c++) {
                int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
                result = Math.max(result, sum);
            }
        }

        System.out.println(result);
    }
}