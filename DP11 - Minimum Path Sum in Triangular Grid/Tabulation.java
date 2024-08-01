public class Tabulation {
    public static int minimumPathSum(int[][] triangle, int n) {
        
        int [][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                dp[i][j] = Math.min(triangle[i][j] + dp[i+1][j] , triangle[i][j] + dp[i+1][j+1] );
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {
        int triangle[][] = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        int n = triangle.length;

        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, n));
    }
}
