import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        Arrays.sort(words);
        for (int i=0; i<n; i++) {
            boolean match = true;
            for (int j=0; j<t.length(); j++) {
                if (words[i].charAt(j) != t.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println(words[i+k-1]);
                return;
            }
        }
    }
}