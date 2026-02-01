import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }
        int ans = -1;
        int[] pCount = new int[n+1];
        for (int i=0; i<m; i++) {
            pCount[penalizedPerson[i]]++;
            if(pCount[penalizedPerson[i]] == k) {
                ans = penalizedPerson[i];
                break;
            }
        }

        System.out.println(ans);
    }
}