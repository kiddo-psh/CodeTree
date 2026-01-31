import java.util.*;
public class Main {
    public static class Code {
        String code;
        char point;
        int time;
        public Code(String code, char point, int time) {
            this.code = code;
            this.point = point;
            this.time = time;
        }
        @Override
        public String toString(){
            return new StringBuilder()
            .append("secret code : ").append(code).append("\n")
            .append("meeting point : ").append(point).append("\n")
            .append("time : ").append(time).toString();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        char mPoint = sc.next().charAt(0);
        int time = sc.nextInt();
        Code c = new Code(sCode, mPoint, time);
        System.out.println(c);
    }
}