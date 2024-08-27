import java.util.Arrays;

public class tabulation {
    public static int maximumChocolates(int r, int c, int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int [][][] dp = new int [row][col][col];

        for(int [][] row2 : dp) {
            for(int [] row1: row2) {
                Arrays.fill(row1, -1);
            }
        }

        for(int i=0; i<col; i++) {
            for(int j=0; j<col; j++) {
                if(i == j) {
                    dp[row-1][i][j] = grid[row-1][i];
                }

                else {
                    dp[row-1][i][j] = grid[row-1][i] + grid[row-1][j];
                }
            }
        }

        for(int i=row-2; i>=0; i--) {
            for(int j=0; j< col; j++) {
                for(int k=0; k<col; k++) {

                    int ans = Integer.MIN_VALUE;

                    for(int di=-1; di<=1; di++) {
                        for(int dj=-1; dj<=1; dj++) {
                            if( !(di + j < 0 || di+j >= col || dj+k < 0 ||  dj+k >= col) ) {
                                if( j == k) {
                                    ans = Math.max(ans , grid[i][j] + dp[i+1][di+j][dj+k]); 
                                }
                                else {
                                    ans = Math.max(ans , grid[i][j] + grid[i][k] + dp[i+1][di+j][dj+k]);
                                }
                            }
                        }
                    }

                    dp[i][j][k] = ans;
                }
            }
        }

        return dp[0][0][col-1];

    }
}