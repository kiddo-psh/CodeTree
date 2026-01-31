import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        //A진수 -> 10진수
        int num = 0;
        for(int i=0; i<N.length(); i++) {
            num = num*A + N.charAt(i) - '0';
        }
        // 10진수 -> B진수
        int cnt = 0;
        int[] digit = new int[20];
        while (num > 0) {
            if (num < B) {
                digit[cnt] = num;
                break;
            }
            digit[cnt++] = num % B;
            num /= B;
        }
        StringBuilder output = new StringBuilder();
        for (int i=cnt; i>=0; i--) {
            output.append(digit[i]);
        }
        System.out.println(output);
    }
}