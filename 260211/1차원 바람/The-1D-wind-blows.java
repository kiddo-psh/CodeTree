import java.util.Scanner;

public class Main {
    static int[][] a;
    static boolean[] visited;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            
            visited = new boolean[n];
            wind (r-1, d);
        }

        for (int[] w : a) {
            for (int x : w) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
    }

    public static void wind(int row, char dir) {
        visited[row] = true;
        if (dir=='L') {
            int temp = a[row][m-1];
            for (int i=m-2; i>=0; i--) {
                a[row][i+1] = a[row][i];
            }
            a[row][0] = temp;

            if (row-1 >= 0 && visited[row-1]==false) {
                for (int i=0; i<m; i++) {
                    if (a[row][i]!=a[row-1][i]) continue;
                    wind(row-1, 'R');
                    break;               
                }
            }
            if (row+1 < n && visited[row+1]==false) {
                for (int i=0; i<m; i++) {
                    if (a[row][i]!=a[row+1][i]) continue;
                    wind(row+1, 'R');
                    break;
                }
            }

        } else {
            int temp = a[row][0];
            for (int i=0; i<m-1; i++) {
                a[row][i] = a[row][i+1];
            }
            a[row][m-1] = temp;

            if (row-1 >= 0 && visited[row-1]==false) {
                for (int i=0; i<m; i++) {
                    if (a[row][i]!=a[row-1][i]) continue;
                    wind(row-1, 'L');
                    break;               
                }
            }
            if (row+1 < n && visited[row+1]==false) {
                for (int i=0; i<m; i++) {
                    if (a[row][i]!=a[row+1][i]) continue;
                    wind(row+1, 'L');
                    break;
                }
            }
        }
    }
}