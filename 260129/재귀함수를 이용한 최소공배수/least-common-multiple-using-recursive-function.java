import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    public static int f(int index) {
        if (index == n-1)
            return arr[index];
        return lcm(arr[index], f(index+1));
    }
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(f(0));
    }
}