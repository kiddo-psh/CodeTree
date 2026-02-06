import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            String command = sc.next();
            if (command.equals("push")) {
                int val = sc.nextInt();
                q.offer(val);
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("empty")) {
                if (q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("pop")) {
                System.out.println(q.poll());
            } else if (command.equals("front")) {
                System.out.println(q.peek());
            }
        }
    }
}