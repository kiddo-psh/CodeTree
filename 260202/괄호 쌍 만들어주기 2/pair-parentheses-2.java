import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int l = input.length();
        int ans = 0;
        for (int i=0; i<l-3; i++) {
            for (int j=i+2; j<l-1; j++) {
                if (
                    input.charAt(i)=='(' &&
                    input.charAt(i+1)=='(' &&
                    input.charAt(j)==')' &&
                    input.charAt(j+1)==')'
                    ) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}