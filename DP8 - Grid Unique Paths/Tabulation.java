public class Tabulation {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int [][] dp = new int[m][n];

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {

                if(row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }

                else if(row > 0 && col > 0) {
                    dp[row][col] = dp[row-1][col] + dp[row][col-1];
                }

                else if(row > 0 && col == 0) {
                    dp[row][col] = dp[row - 1][col];
                }

                else if(col > 0 && row == 0) {
                    dp[row][col] = dp[row][col-1];
                }

            }
        }

        return dp[m-1][n-1];
    }
}