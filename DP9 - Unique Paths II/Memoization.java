import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int [][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return mazeObstacles(n-1, m-1, mat , dp);
    }

    private static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat, int [][] dp) {
        if( n == 0 && m == 0) {
            return 1;
        }

        if(n >= 0 && m >= 0 && mat.get(n).get(m) == -1) {
            return 0;
        }

        if(n < 0 || m < 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        return (( mazeObstacles(n-1, m, mat, dp) % 1000000007 ) + (mazeObstacles(n, m-1, mat , dp) % 1000000007 ) )% 1000000007;
    }


}
