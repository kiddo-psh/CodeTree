import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int result = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=i; k<n; k++) {
                    for (int l=j; l<m; l++) {


                        for (int w=0; w<n; w++) {
                            for (int x=0; x<m; x++) {
                                for (int y=w; y<n; y++) {
                                    for (int z=x; z<m; z++) {

                                        //if (i*m+j >= w*m+y) continue;
                                        if (check(i, j, k, l, w, x, y, z)) {
                                            result = Math.max(calc(i,j,k,l,w,x,y,z), result);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
    static boolean check (int i, int j, int k, int l, int w, int x, int y, int z) {
        return (k < w) || (y < i) || (l < x) || (z < j);
    }

    static int calc(int i, int j, int k, int l, int w, int x, int y, int z) { 
       int sum = 0;
       for (int r=i; r<=k; r++) {
        for (int c=j; c<=l; c++) {
            sum += grid[r][c];
        }
       }
       for (int r=w; r<=y; r++) {
        for (int c=x; c<=z; c++) {
            sum += grid[r][c];
        }
       }
       return sum;
    }
}