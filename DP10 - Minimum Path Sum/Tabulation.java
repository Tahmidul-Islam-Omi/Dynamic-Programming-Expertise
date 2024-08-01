import java.util.Arrays;

public class Tabulation {
    public static int minSumPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int [][] dp = new int[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i == 0 && j==0) {
                    dp[i][j] = grid[i][j];
                }

                if(i == 0 && j !=0 ) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }

                if(i != 0 && j ==0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }

                if(i != 0 && j !=0) {
                    dp[i][j] = Math.min (grid[i][j] + dp[i-1][j] , grid[i][j] + dp[i][j-1]);
                }
            }
        }

        return dp[row-1][col-1];
    }
}
