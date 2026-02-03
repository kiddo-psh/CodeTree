import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i==j) {
                    answer++;
                    continue;
                }
                int sum = 0; int cnt = 0;
                for (int k = i; k <= j; k++) {
                    cnt++;
                    sum += arr[k];
                }
                if (sum%cnt != 0) continue;
                sum /= cnt;
                for (int k = i; k <= j; k++) {
                    if (sum == arr[k]) {
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}