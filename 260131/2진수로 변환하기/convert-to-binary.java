import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int[] digit = new int[20];
        while (n>0) {
            if (n < 2) {
                digit[cnt] = n;
                break;    
            }
            digit[cnt++] = n % 2;
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=cnt; i>=0; i--) {
            sb.append(digit[i]);
        } 
        System.out.println(sb);
    }
}