public class SpaceOptimization {
    public static void main(String[] args) {
        int n=6;

        int prev2 = 0;
        int prev1 = 1;

        int curr = 0 ;

        for (int i=2; i<=n; i++) {
            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        } 

        System.out.println(curr);
    }
}

/*
  -Time Complexity - 0(N) -> Overlapping subproblem return answer in 0(1) constant time. And the total number of subproblems here is N.
  -Space Complexity - 0(1)
*/
