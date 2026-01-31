import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int t1 = a * 60 + b;
        int t2 = c * 60 + d;
        System.out.println(t2 - t1);
    }
}