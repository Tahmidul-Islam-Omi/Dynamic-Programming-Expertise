import java.util.Arrays;

public class Memoization {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePaths(m-1, n-1, dp);

    }

    private static int uniquePaths(int m, int n, int[][] dp) {

        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        
        if (m == 0 && n == 0) {
            return 1;
        }

        if(m < 0 || n < 0) {
            return 0;
        }

        return dp[m][n] = uniquePaths(m-1, n ,dp) + uniquePaths(m, n-1 , dp);
    }

}
