import java.util.Arrays;

public class Memoization {
    public static int minSumPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int [][] dp = new int[row][col];

        for(int[] Row: dp) {
            Arrays.fill(dp , - 1);
        }

        return minSumPath(grid , row-1, col-1 , dp);
    }

    private static int minSumPath(int [][] grid, int row, int col, int[][] dp) {
        if(row == 0 && col == 0) {
            return grid[row][col];
        }

        if(row < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        return dp[row][col] = Math.min(grid[row][col] + minSumPath(grid , row-1, col,  dp) , grid[row][col] + minSumPath(grid , row, col-1,  dp));

    }
}
