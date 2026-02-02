import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int ans = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-2; j++) { 
                int s = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                //if (i+3 <= n-3) {
                    for (int k=j+3; k<n-2; k++) {
                        sum = s + arr[i][k] + arr[i][k+1] + arr[i][k+2];
                        ans = Math.max(ans, sum);
                    }
                //}
                for (int k=i+1; k<n; k++) {
                    for (int l=0; l<n-2; l++) {
                        sum = s + arr[k][l] + arr[k][l+1] + arr[k][l+2];
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}