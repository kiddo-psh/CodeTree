import java.util.*;

class Item {
    String id;
    int code;
    Item() {
        id = "codetree";
        code = 50;
    }
    Item(String id, int code) {
        this.id = id;
        this.code = code;
    }
    @Override
    public String toString() {
        return new StringBuilder()
            .append("product ").append(code)
            .append(" is ").append(id)
            .toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        System.out.println(new Item());
        System.out.println(new Item(id2, code2));
    }
}