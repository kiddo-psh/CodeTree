import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        
        for (int i=s1-1; i<=e1-1; i++) {
            blocks[i] = 0;
        }
        n -= (e1-s1+1);
        int[] temp = new int[n];
        int tempIdx = 0;
        for (int i=0; i<blocks.length; i++) {
            if (blocks[i]==0) continue;
            temp[tempIdx++] = blocks[i];
        }
        blocks = temp;

        for (int i=s2-1; i<=e2-1; i++) {
            blocks[i] = 0;
        }
        n -= (e2-s2+1);
        temp = new int[n];
        tempIdx = 0;
        for (int i=0; i<blocks.length; i++) {
            if (blocks[i]==0) continue;
            temp[tempIdx++] = blocks[i];
        }
        blocks = temp;

        System.out.println(blocks.length);
        for (int b : blocks) {
            System.out.println(b);
        }
        
    }
}