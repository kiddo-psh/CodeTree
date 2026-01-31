import java.util.*;

class Account {
    String id;
    int level;

    public Account() {
        this.id = "codetree";
        this.level = 10;
    }
    public Account(String id, int level) {
        this.id = id;
        this.level = level;
    }
    @Override
    public String toString() {
        return new StringBuilder()
        .append("user ").append(id)
        .append(" lv ").append(level)
        .toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String i = sc.next();
        int l = sc.nextInt();
        Account a1 = new Account();
        Account a2 = new Account(i, l);
        System.out.println(a1);
        System.out.println(a2);
    }
}