import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next().toCharArray();
        
        int result = 100;
        for (int i=0; i<A.length; i++) {
            shift();
            result = Math.min(result, RLE());
        }

        System.out.print(result);
    }
    static void shift() {
        char temp = A[A.length-1];
        for (int i=A.length-2; i>=0; i--) {
            A[i+1] = A[i];
        }
        A[0] = temp;
    }

    static int RLE() {
        int len = 0;
        char c = A[0];
        int count = 1;
        for (int i=1; i<A.length; i++) {
            if (c != A[i]) {
                if (count >= 10) len +=3;
                else len +=2;
                c = A[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count > 0) {
            if (count >= 10) len +=3;
            else len +=2;
        }
        return len;
    }

    static char[] A;
}