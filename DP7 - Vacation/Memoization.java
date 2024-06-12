import java.util.Arrays;

public class Memoization {

    public static int ninjaTraining(int n, int points[][]) {
        
        int [][] dp = new int[n][4];
        
        for(int[] row : dp) {
            Arrays.fill(row , -1);
        }

        return ninjaTraining(n-1 , points , dp , 3 );
        
    }

    private static int ninjaTraining(int day, int[][] points, int[][] dp, int lastActivity) {

        if(dp[day][lastActivity] != -1) {
            return dp[day][lastActivity];
        }

        if(day == 0) {

            int maxPoint = 0;

            for(int i=0; i<=2 ; i++) {
                if(i != lastActivity) {
                    maxPoint = Math.max(maxPoint , points[day][i]);
                }
            }

            return dp[day][lastActivity] = maxPoint;
        }

        int maxPoint = 0;

        for(int i=0; i<=2 ; i++) {
            if(i != lastActivity) {
                maxPoint = Math.max(maxPoint , points[day][i] + ninjaTraining(day-1, points , dp , i));
            }
        }

        return dp[day][lastActivity] = maxPoint;
    }

}
