import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int [] dp = new int[nums.size()];
        Arrays.fill(dp , -1);

        return maximumNonAdjacentSum(nums, dp , nums.size() - 1);
    }

    private static int maximumNonAdjacentSum(ArrayList<Integer> nums, int[] dp , int n) {
        
        if(n == 0) {
            return nums.get(0);
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int pick = nums.get(n) + maximumNonAdjacentSum( nums, dp , n-2);
        int nonPick = maximumNonAdjacentSum(nums, dp, n-1);

        return dp[n] = Integer.max(pick, nonPick);

    }

}
