import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = 0;
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == ')') continue;
            for (int j=i+1; j<str.length(); j++) {
                if (str.charAt(j) == ')') {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}