import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String op = sc.next();
            if (op.equals("push_back")) {
                int val = sc.nextInt();
                list.add(val);
            } else if (op.equals("get")) {
                int val = sc.nextInt();
                System.out.println(list.get(val-1));
            } else if (op.equals("size")) {
                System.out.println(list.size());
            } else if (op.equals("pop_back")) {
                list.remove(list.size()-1);
            }
        }
    }
}