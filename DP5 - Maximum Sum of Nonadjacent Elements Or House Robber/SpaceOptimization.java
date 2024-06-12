import java.util.ArrayList;

public class SpaceOptimization {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {

        int prev2 = 0;
        int prev1 = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            
            int pick = nums.get(i);

            if(i > 1) {
                pick += prev2;
            }
            
            int nonPick = prev1;

            int curr = Integer.max(pick, nonPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(23);

        System.out.println(maximumNonAdjacentSum(nums));
    }
}
