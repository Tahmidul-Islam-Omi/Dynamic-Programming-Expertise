import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        int n=7;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}


/*
  -Time Complexity - 0(N) -> Overlapping subproblem return answer in 0(1) constant time. And the total number of subproblems here is N.
  -Space Complexity - 0(N) -> N sized Array
*/