import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] stack = new char[50];
        int top = 0;
        boolean answer = true;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)=='(') {
                stack[top++] = '(';
            } else {
                if (top==0) {
                    answer = false;
                    break;
                }
                top--;
            }
        }
        if (top!=0 || !answer)
            System.out.println("No");
        else 
            System.out.println("Yes");
    }
}