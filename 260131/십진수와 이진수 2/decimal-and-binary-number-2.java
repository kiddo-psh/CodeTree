import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        int n = Integer.parseInt(binary, 2);
        n *= 17;
        System.out.println(Integer.toBinaryString(n));
    }
}