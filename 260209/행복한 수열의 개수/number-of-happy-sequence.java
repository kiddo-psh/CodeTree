import java.util.Scanner;
  
public class Main {
    static int result = 0;
    static int[][] grid;
    static int n, m;

    static void findRow() {
        for (int i=0; i<n; i++) {
            int num = grid[i][0];
            int count = 1;
            for (int j=1; j<n; j++) {
                if (num != grid[i][j]) {
                    num = grid[i][j];
                    count = 1;
                } else {
                    count++;
                }
                if (count == m) {
                    result++;
                    break;
                }
            }
        }
    }
    static void findCol() {
        for (int i=0; i<n; i++) {
            int num = grid[0][i];
            int count = 1;
            for (int j=1; j<n; j++) {
                if (num != grid[j][i]) {
                    num = grid[j][i];
                    count = 1;
                } else {
                    count++;
                }
                if (count == m) {
                    result++;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        if(m==1) {
            System.out.println(2*n);
            return;
        }

        findRow();
        findCol();

        System.out.println(result);
    }
}