import java.util.Arrays;

public class memoization {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int [][] dp = new int[n][k+1];

        for(int [] row : dp) {
            Arrays.fill( row , -1);
        }

        int ans = subsetSumToK(n-1, k, arr , dp);

        if(ans == 1) {
            return true;
        }

        return false;
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
        if(arr[ind] <= k) {
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
