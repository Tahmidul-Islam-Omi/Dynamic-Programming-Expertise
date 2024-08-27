public class memoization {
    public static int minSubsetSumDifference(int[] arr, int n) {
        // Write your code here.

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        int k = totalSum;

        int[][] dp = new int[n][k + 1];

        for (int ind = 0; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                if (target == 0) {
                    dp[ind][target] = 1;
                }

                if (ind == 0) {
                    if (arr[ind] == target) {
                        dp[ind][target] = 1;
                    }
                }
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                if (take == 1 || notTake == 1) {
                    dp[ind][target] = 1;
                }

                else {
                    dp[ind][target] = 0;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= totalSum; i++) {
            if (dp[n - 1][i] == 1) {
                ans = Math.min(ans, Math.abs(i - (totalSum - i)));
            }
        }

        return ans;
    }
}
