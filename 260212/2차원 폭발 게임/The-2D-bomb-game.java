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
                if(gg!=0)result++;
            }
        }
        System.out.println(result);
    }

    static void boom() {
        boolean flag = false;
        for (int col=0; col<n; col++) {
            int prev = grid[n-1][col];
            int count = 0;
            for (int row=n-1; row>=0; row--) {
                if (grid[row][col] == 0) {
                    prev = 0;
                    count = 0;
                    continue;
                }
                if (grid[row][col] == prev) {
                    count++;
                } else {
                    prev = grid[row][col];
                    count = 1;
                }
                
                if (count >= m) {
                    flag = true;
                    for (int i=row; i<=row+count-1; i++) {
                        if (grid[i][col]==0) break;
                        grid[i][col] = 0;
                    }
                }
            }
        }
        gravity();
        if (flag) boom();
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