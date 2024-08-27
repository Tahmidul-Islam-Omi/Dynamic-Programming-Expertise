import java.util.Arrays;

public class memoization {
    public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if(sum % 2 != 0) {
            return true;
        }

        else {

            int [][] dp = new int[n][(sum/2)+1];

            for(int [] row : dp) {
                Arrays.fill( row , -1);
            }
            
            int ans = subsetSumToK(n-1, sum/2, arr, null);
            if(ans == 1) {
                return true;
            }

            else {
                return false;
            }
        }
	}

    private static int subsetSumToK(int ind, int k, int arr[], int [][] dp) {

        if(k == 0) {
            return 1;
        }

        if( ind == 0) {
            if(arr[ind] == k) {
                return 1;
            }

            return 0;
        }

        if(dp[ind][k] != -1) {
            return dp[ind][k];
        }

        int notTake = subsetSumToK(ind-1, k, arr, dp);
        int take = 0;
        if(arr[ind-1] <= k) {
            take = subsetSumToK(ind-1, k - arr[ind], arr, dp);
        }

        if(notTake == 1 || take == 1) {
            return dp[ind][k] = 1;
        }

        else {
            return dp[ind][k] = 0;
        }
    }
}
