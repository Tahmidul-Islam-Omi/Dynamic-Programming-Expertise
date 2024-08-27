import java.util.Arrays;

public class memoization {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int [][] dp =new int[num.length][tar+1];

        for(int [] row: dp) {
            Arrays.fill(row , -1);
        }

        return findWays(num , num.length-1, tar, dp);
        
    }

    private static int findWays(int arr[], int ind ,int tar, int [][] dp) {

        if(ind == 0) {
            if(tar == 0 && arr[ind] == 0) {
                return 2;
            }

            if(tar == 0 || tar == arr[0]) {
                return 1;
            }

            return 0;
        }

        if(dp[ind][tar] != -1) {
            return dp[ind][tar];
        }

        int notTake = findWays(arr, ind-1, tar, dp);
        int take = 0;
        if(arr[ind] <= tar) {
            take = findWays(arr, ind-1, tar - arr[ind], dp);
        }

        return dp[ind][tar] =  (notTake % 1000000007 + take % 1000000007) % 1000000007;

    }
}
