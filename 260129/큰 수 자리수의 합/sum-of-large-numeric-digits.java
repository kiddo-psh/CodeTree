import java.util.Scanner;
public class Main {
    public static int recur(int n) {
        if(n/10 == 0) return n%10;
        return n%10 + recur(n/10);
    }
    public static int f(int a, int b, int c) {
        int res = a * b * c;
        return recur(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(f(a, b, c));
    }
}