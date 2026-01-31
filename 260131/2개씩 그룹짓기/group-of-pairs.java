import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int sum = nums[i] + nums[n*2-1-i];
            result = Math.max(sum, result);
        }

        System.out.println(result);
    }
}