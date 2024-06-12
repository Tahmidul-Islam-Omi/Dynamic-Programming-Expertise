import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {
    
    public static long houseRobber(int[] valueInHouse) {

        if(valueInHouse.length == 1) {
            return valueInHouse[0];
        }
		
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        for(int i=0; i< valueInHouse.length; i++) {

            if( i !=0 ) {
                arr2.add(valueInHouse[i]);
            }

            if(i != valueInHouse.length - 1) {
                arr1.add(valueInHouse[i]);
            }
        }

        long [] dp1 = new long[arr1.size()];
        long [] dp2 = new long[arr2.size()];

        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);

        long a = solve(arr1 , dp1 , arr1.size()-1);
        long b = solve(arr2 , dp2 , arr2.size()-1);

        return Math.max(a, b);
			
	}

    private static long solve(ArrayList<Integer> arr, long[] dp , int idx) {
        
        if(idx == 0) {
            return arr.get(0);
        }

        if(idx < 0) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        long pick = arr.get(idx) + solve(arr , dp , idx-2);
        long nonPick  = solve(arr , dp , idx-1);

        return dp[idx] = Math.max(pick, nonPick);
    }

    public static void main(String[] args) {
        int [] valueInHouse = {55};
        System.out.println(houseRobber(valueInHouse));
    }
}
