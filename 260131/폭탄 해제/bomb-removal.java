import java.util.*;

class Bomb {
    String code;
    char color;
    int times;

    public Bomb(String code, char color, int times) {
        this.code = code;
        this.color = color;
        this.times = times;
    }

    @Override
    public String toString() {
        return new StringBuilder()
        .append("code : ").append(code).append("\n")
        .append("color : ").append(color).append("\n")
        .append("second : ").append(times).toString();
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uCode = sc.next();
        char lColor = sc.next().charAt(0);
        int time = sc.nextInt();
        System.out.println(new Bomb(uCode, lColor, time));
    }
}