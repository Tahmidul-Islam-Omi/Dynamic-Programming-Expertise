import java.util.Arrays;

public class Memoization {
    public static int minimumPathSum(int[][] triangle, int n) {

        int [][] dp = new int[n][n];

        for(int [] Row : dp) {
            Arrays.fill(dp, -1);
        }

        return minimumPathSum(triangle, n , 0,0, dp);

    }

    private static int minimumPathSum(int [][] triangle, int n, int row , int col , int [][] dp) {
        if(row == n-1) {
            return triangle[row][col];
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        return dp[row][col] = Math.min(triangle[row][col] + minimumPathSum(triangle, n ,row+1 , col, dp) , triangle[row][col] + minimumPathSum(triangle, n ,row+1 , col+1, dp));
    }
}
