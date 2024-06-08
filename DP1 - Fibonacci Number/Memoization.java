import java.util.Arrays;

public class Memoization {

    static int fibonacci(int n, int[] dp) {
        if(n <= 1) {
            return 1;
        }

        if( dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
    }
    public static void main(String[] args) {
        int n=6;
        int [] dp = new int[n+1];

        Arrays.fill(dp,-1);
        
        System.out.println(fibonacci(n, dp));
        
    }
}

/*
  -Time Complexity - 0(N) -> Overlapping subproblem return answer in 0(1) constant time. And the total number of subproblems here is N.
  -Space Complexity - 0(N + N) = 0(N) -> N stack space & N sized Array
*/