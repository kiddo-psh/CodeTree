import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("push_front")) {
                int val = sc.nextInt();
                list.addFirst(val);
            } else if (command.equals("push_back")) {
                int val = sc.nextInt();
                list.addLast(val);
            } else if (command.equals("pop_front")) {
                System.out.println(list.pollFirst());
            } else if (command.equals("pop_back")) {
                System.out.println(list.pollLast());
            } else if (command.equals("size")) {
                System.out.println(list.size());
            } else if (command.equals("empty")) {
                if (list.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("front")) {
                System.out.println(list.get(0));
            } else if (command.equals("back")) {
                System.out.println(list.get(list.size()-1));
            }
        }
    }
}