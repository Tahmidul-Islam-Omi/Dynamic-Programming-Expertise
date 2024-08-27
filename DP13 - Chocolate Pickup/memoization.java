import java.util.Arrays;

public class memoization {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return maximumChocolates(0, 0, grid[0].length - 1, grid, dp);
    }

    private static int maximumChocolates(int i, int j1, int j2, int[][] grid, int[][][] dp) {

        if (j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) {
            return (int) Math.min(-10, 9);
        }

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            }

            else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int ans = (int) Math.min(-10, 9);

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if(j1 == j2) {
                    ans = Math.max(ans , grid[i][j1] + maximumChocolates(i+1, j1+dj1, j2+dj2, grid, dp));
                }

                else {
                    ans = Math.max(ans , grid[i][j1] + grid[i][j2] + maximumChocolates(i+1, j1+dj1, j2+dj2, grid, dp));
                }
            }
        }

        System.out.println("i "+ i + " : " + ans);
        return dp[i][j1][j2] = ans;
    }
}