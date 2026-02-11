import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<=n; k++) {
                    int gold = digging(i, j, k); // n 크기로 채굴
                    result = Math.max(gold, result);
                }
            }
        }

        System.out.println(result);
    }

    static int digging(int r, int c, int k) {
        int count = 0;
        int cost = k*k + (k+1)*(k+1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (Math.abs(i-r)+Math.abs(j-c) <= k) {
                    if (grid[i][j] == 1) count++;
                }
            }
        }
        if (count*m - cost < 0) return -1;
        return count;
    }
}