import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int st = 11*24*60 + 11*60 + 11;
        int et = A*24*60 + B*60 + C;
        System.out.println(et - st);
    }
}