import java.util.Arrays;
import java.util.Scanner;

public class Memoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int [] heights = new int[n];

        for(int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int [] dp = new int[n];
        Arrays.fill(dp,-1 );

        System.out.println(FrogJump(n-1 , k , heights ,dp));
        
    }

    private static int FrogJump(int n, int k, int[] heights , int[] dp) {

        if(n == 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++) {

            if(n-i >= 0) {
                ans = Math.min(ans , ( FrogJump(n-i, k, heights, dp) + Math.abs(heights[n] - heights[n-i]) ) ) ;
            }
        }

        return dp[n] = ans;
    }
    
}
