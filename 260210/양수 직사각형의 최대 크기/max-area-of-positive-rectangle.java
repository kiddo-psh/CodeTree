import java.util.Scanner;
public class Main {
    static int n, m;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // 직사각형 만들기 = 두 점 찍기
        
        int result = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<n; l++) {
                        result = Math.max(result, check(i, j, k, l));
                    }
                }
            }
        }

        System.out.println(result);
    
    }

    static int check(int r1, int c1, int r2, int c2) {
        int count = 0;
        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                if (grid[r][c]<0) return -1;
                count++;
            }
        }
        return count;
    }
}