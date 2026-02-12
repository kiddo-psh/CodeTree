import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i=0; i<k; i++) {
            boom();
            rotate();
        }

        int result = 0;
        for (int g[] : grid) {
            for (int gg : g) {
                result++
            }
        }
            System.out.println(result);
    }

    static void boom() {
        for (int col=0; col<n; col++) {
            int prev = grid[n-1][col];
            int count = 1;
            for (int row=n-2; row>=0; row--) {
                if (grid[row][col] == 0) {
                    prev = 0;
                    count = 0;
                    continue;
                }
                if (grid[row][col] == prev) {
                    count++;
                    if (count >= m) {
                        for (int i=row; i<=row+count-1; i++) {
                            grid[i][col] = 0;
                        }
                    }
                } else {
                    prev = grid[row][col];
                    count = 1;
                }
            }
        }
        gravity();
    }

    static void rotate() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n-1-i] = grid[i][j];
            }
        }
        grid = temp;
        gravity();
        boom();
    }

    static void gravity() {
        int[][] temp = new int[n][n];
        for (int col=0; col<n; col++) {
            int rowIdx = n-1;
            for (int row=n-1; row>=0; row--) {
                if (grid[row][col] == 0) continue;
                temp[rowIdx--][col] = grid[row][col];
            }
        }
        grid = temp;
    }
}