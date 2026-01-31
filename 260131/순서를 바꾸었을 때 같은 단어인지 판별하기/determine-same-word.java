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
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i=0; i<str1.length; i++) {
            if (str1[i] != str2[i]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}