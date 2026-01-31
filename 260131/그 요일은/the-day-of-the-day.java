import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String date = sc.next();
        int[] numDays = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i=1; i<=12; i++) {
            if (i < m1) {
                d1 += numDays[i];
            }
            if (i < m2) {
                d2 += numDays[i];
            }
        }
        int res = (d2 - d1) / 7;
        for (int i=0; i<=(d2-d1)%7; i++) {
            if (day[i].equals(date)) {
                res++;
            }
        }
        System.out.println(res);
    }
}