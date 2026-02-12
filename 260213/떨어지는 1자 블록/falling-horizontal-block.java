import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt()-1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int target=0;
        boolean flag;
        for (int row=0; row<n; row++) {
            flag = true;
            for (int col=k; col<k+m; col++) {
                if (grid[row][col]!=0) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                for (int col=k; col<k+m; col++) {
                    grid[row-1][col] = 1;
                }
                break;
            }
        }

        for (int[] arr : grid) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}