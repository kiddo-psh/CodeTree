import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (a.equals("1")) {
            System.out.println(0);
            return;
        }
        StringBuilder ans = new StringBuilder().append('1');
        boolean flag = false;
        for (int i=1; i<a.length(); i++) {
            if (a.charAt(i)=='0' && flag == false) {
                flag = true;
                ans.append('1');
            } else ans.append(a.charAt(i));
        }
        int result = Integer.parseInt(ans.toString(), 2);
        System.out.println(result);
    }
}