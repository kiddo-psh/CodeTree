import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        if (word1.length() != word2.length()) {
            System.out.println("No");
            return;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        
        String str1 = new String(c1);
        String str2 = new String(c2);

        if (str1.equals(str2)) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}