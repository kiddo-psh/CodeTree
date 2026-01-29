import java.util.Scanner;
public class Main {
    static int res = 0;
    public static void f(int n) {
        if(n==1) return;
        res++;
        if(n%2==0) f(n/2);
        else f(3*n+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        System.out.println(res);
    }
}