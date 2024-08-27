import java.util.* ;
import java.io.*; 

public class memoization {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int [][] dp = new int[num.length][x+1];

        for(int [] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans= minimumElements(num, x , num.length-1 , dp);

        if(ans >= (int) Math.pow(10,9)) {
            return -1;
        }

        return ans;
    }

    private static int minimumElements(int num[] , int x , int ind , int[][] dp) {
        if(ind == 0) {
            if(x % num[0] == 0) {
                return x / num[0];
            }

            else {
                return (int) Math.pow(10,9);
            }
        } 

        if(dp[ind][x] != -1) {
            return dp[ind][x];
        }

        int notTake = minimumElements(num, x, ind-1, dp);
        int take = (int) Math.pow(10, 9);

        if(num[ind] <= x) {
            take = 1 + minimumElements(num, x-num[ind] ,ind, dp);
        }

        return dp[ind][x] = Math.min(notTake, take);
    }
}