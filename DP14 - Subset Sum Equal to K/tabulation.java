public class tabulation {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int [][] dp = new int[n][k+1];

        for(int ind = 0; ind < n ; ind++) {
            for(int target = 0; target <= k; target++) {
                if(target == 0) {
                    dp[ind][target] = 1;
                }

                if(ind == 0) {
                    if(arr[ind] == target) {
                        dp[ind][target] = 1;
                    }
                }
            }
        }

        for(int ind = 1; ind < n; ind ++) {
            for(int target = 1; target <= k; target++) {
                int notTake = dp[ind-1][target];
                int take = 0;
                if(arr[ind] <= target) {
                    take = dp[ind-1][target - arr[ind]];
                }

                if(take == 1 || notTake == 1) {
                    dp[ind][target] = 1;
                }

                else {
                    dp[ind][target] = 0;
                }
            }
        }

        if(dp[n-1][k] == 1 ) {
            return true;
        }

        else {
            return false;
        }
    }
}
