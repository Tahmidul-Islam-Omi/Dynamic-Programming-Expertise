// Here is the top-down approach of
// dynamic programming

import java.io.*;
import java.util.*;

public class tabulation {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int [][] dp = new int[n][maxWeight+1];

        for(int ind=0; ind<n; ind++) {
            for(int w=0; w <= maxWeight; w++) {
                if( w==0) {
                    dp[ind][w] = 0;
                }

                if(ind == 0 && weight[ind] <= w) {
                    dp[ind][w] = value[ind];
                }

            }
        }

        for(int ind=1; ind<n; ind++) {
            for(int w=1; w <= maxWeight; w++) {
                if(weight[ind] <= w) {
                    dp[ind][w] = Math.max(value[ind] + dp[ind-1][w- weight[ind]] , dp[ind-1][w]);
                }

                else {
                    dp[ind][w] = dp[ind-1][w];
                }
            }
        }

        return dp[n-1][maxWeight];

    }

}
