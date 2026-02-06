import java.util.Scanner;
public class Main {
    static int[] arr = new int[5];
    static int maxPoint = 0;
    static int result = Integer.MAX_VALUE;

    static void calc (int i, int j, int k, int l) {
        int t1 = arr[i] + arr[j];
        int t2 = arr[k] + arr[l];
        int t3 = maxPoint - t1 - t2;

        if (t1!=t2 && t2!=t3 && t1!=t3) {
            int maxT = Math.max(t1, Math.max(t2, t3));
            int minT = Math.min(t1, Math.min(t2, t3));
            result = Math.min(result, maxT-minT);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<5; i++) {
            arr[i] = sc.nextInt();
            maxPoint += arr[i];
        }

        for (int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {

                for (int k=0; k<5; k++) {
                    for (int l=k+1; l<5; l++) {
                        
                        if(i==k || i==l || j==k || j==l) continue;
                        calc(i, j, k, l);
                    }
                }
            }
        }

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
        // Please write your code here.
    }
}