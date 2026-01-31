import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int[] numDays = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i=1; i<=12; i++) {
            if (i < m1) {
                d1 += numDays[i];
            }
            if (i < m2) {
                d2 += numDays[i];
            }
        }
        String res;
        if ((d2-d1)>=0) res = day[(d2-d1)%7];
        else res = day[(d1-d2)%7==0 ? 0 : 7-(d1-d2)%7];
        System.out.println(res);
    }
}