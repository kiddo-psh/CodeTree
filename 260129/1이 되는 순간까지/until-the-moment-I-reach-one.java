import java.util.Scanner;
public class Main {
    static int count = 0;
    public static int F(int n) {
        if(n==1) {
            return count;
        }
        count++;
        if(n%2==0) {
            return F(n/2);
        } else {
            return F(n/3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(F(n));
    }
}