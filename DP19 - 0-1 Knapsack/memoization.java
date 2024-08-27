import java.util.Arrays;

public class memoization {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int [][] dp = new int[n][maxWeight+1];

        for(int [] row: dp) {
            Arrays.fill(row, -1);
        }

        return knapsack(weight, value, n-1, maxWeight , dp);
    }

    private static int knapsack(int[] weight, int[] value, int ind, int maxWeight, int[][] dp) {
        if(ind < 0 || maxWeight == 0) {
            return 0;
        }

        if(dp[ind][maxWeight] != 0) {
            return dp[ind][maxWeight];
        }

        if( weight[ind] <= maxWeight) {
            return dp[ind][maxWeight] = Math.max( (value[ind] + knapsack(weight , value, ind-1, maxWeight - weight[ind] ,dp)) , knapsack(weight, value, ind-1, maxWeight , dp));
        }

        else {
            return dp[ind][maxWeight] = knapsack(weight, value, ind-1, maxWeight , dp);
        }
    }
}
