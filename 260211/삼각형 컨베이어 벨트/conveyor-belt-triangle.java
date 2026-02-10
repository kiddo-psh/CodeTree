import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        for (int i=0; i<t; i++) {
            int lLast = l[n-1];
            int rLast = r[n-1];
            int dLast = d[n-1];

            for (int j=n-2; j>=0; j--) {
                l[j+1] = l[j];
                r[j+1] = r[j];
                d[j+1] = d[j];
            }

            l[0] = dLast;
            r[0] = lLast;
            d[0] = rLast;
        }

        for (int x : l) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : r) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : d) {
            System.out.print(x + " ");
        }
    }
}