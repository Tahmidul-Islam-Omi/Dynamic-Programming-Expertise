import java.util.Arrays;

public class Memoization {
    public static final int mod = 1000000007;


    public static long CountDistinctWayToClimbStair(int nStairs, long [] dp) {
        
        if(nStairs < 2) {
			return 1;
		}

        if(dp[nStairs] != -1) {
            return dp[nStairs];
        }

        return dp[nStairs] = ( CountDistinctWayToClimbStair(nStairs-1, dp) + CountDistinctWayToClimbStair(nStairs-2, dp) ) % mod;
    }

    public static long countDistinctWayToClimbStair(int nStairs) {
		long [] dp = new long [nStairs+1];

        Arrays.fill(dp, -1);

        return CountDistinctWayToClimbStair(nStairs , dp);

	} 
    public static void main(String[] args) {
        int n = 49;
        System.out.println(countDistinctWayToClimbStair(n));
    }
}
