import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        LinkedList<Character> list = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator(list.size());

        while (m-- > 0) {
            char command = sc.next().charAt(0);

            if (command == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command == 'R') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command == 'P') {
                char val = sc.next().charAt(0);
                iter.add(val);
            } else if (command == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                    iter.remove();
                }
            }
        }
        iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        // Please write your code here.
    }
}