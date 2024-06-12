import java.util.ArrayList;

public class Tabulation {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int [] dp = new int[nums.size()];
        dp[0] = nums.get(0);


        for(int i=1; i<nums.size(); i++) {

            int pick = nums.get(i);

            if(i>1) {
                pick += dp[i-2];
            }

            int nonPick = dp[i-1];

            dp[i] = Math.max(pick, nonPick);

        }

        return dp[nums.size()-1];
    }
}
