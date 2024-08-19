import java.util.Arrays;

public class memoization {
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int [][] dp =new int[matrix.length][matrix[0].length];

        for(int [] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxPathSum = Integer.MIN_VALUE;

        for(int col=0; col<matrix[0].length; col++) {
            maxPathSum = Math.max(maxPathSum, getMaxPathSum(matrix , dp , 0 , col));
        }

        return maxPathSum;
    }

    private static int getMaxPathSum(int[][] matrix, int [][] dp , int i, int j) {

        if(j < 0 || j>= matrix[0].length) {
            //return Integer.MIN_VALUE;
            return (int) Math.pow(-10, 9);
        }

        if(i == matrix.length-1 ) {
            return matrix[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = Math.max(matrix[i][j] + getMaxPathSum(matrix , dp, i+1 , j-1) , Math.max( matrix[i][j] + getMaxPathSum(matrix , dp, i+1 , j) , matrix[i][j] + getMaxPathSum(matrix , dp, i+1 , j+1)))  ;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3 ,-56,78,1},
                {9,8,7 ,12,3,1},
                {4,-5,6,-78,1,-3},
                {56,1,-34,56,1,-2}
        };

        System.out.println(getMaxPathSum(matrix));
    }
}
