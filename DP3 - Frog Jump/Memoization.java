import java.util.Arrays;

public class Memoization {

    public static int frogJump(int n, int heights[] , int[] dp) {
        if (n == 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int jumpOne = Math.abs(heights[n] - heights[n-1]) + frogJump(n-1, heights, dp);

        int jumpTwo = Integer.MAX_VALUE;

        if(n-2 >= 0) {
            jumpTwo = Math.abs(heights[n] - heights[n-2]) + frogJump(n-2, heights, dp);
        }

        return dp[n] = Integer.min(jumpOne, jumpTwo);

    }

    public static void main(String[] args) {

        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        System.out.println(frogJump(n - 1, height, dp));
    }
}
