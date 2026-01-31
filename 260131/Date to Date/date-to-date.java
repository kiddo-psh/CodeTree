import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int t1 = d1, t2 = d2;
        for (int i=1; i<=12; i++) {
            if (i<m1) {
                t1 += num_of_days[i];
            }
            if (i<m2) {
                t2 += num_of_days[i];
            }
        } 
        System.out.println(t2 - t1 + 1);
    }
}