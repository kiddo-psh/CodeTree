import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        
        int cnt = 0;
        int[] digit = new int[20];
        while(n > 0) {
            if (n < b) {
                digit[cnt] = n;
                break;
            }
            digit[cnt++] = n%b;
            n/=b;
        }
        StringBuilder output = new StringBuilder();
        for (int i=cnt; i>=0; i--) {
            output.append(digit[i]);
        }

        System.out.println(output);

    }
}