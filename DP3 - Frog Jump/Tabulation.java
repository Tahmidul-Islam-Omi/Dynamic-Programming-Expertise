public class Tabulation {

    public static int frogJump(int n, int heights[]) {
        int prev2 = 0;
        int prev1 = Math.abs ( heights[1] - heights[0]);
        int curr = 0;

        for(int i=2; i<heights.length; i++) {
            int jumpOne = prev1 + Math.abs ( heights[i] - heights[i-1]);
            int jumpTwo = prev2 + Math.abs ( heights[i] - heights[i-2]);

            curr = Math.min(jumpOne, jumpTwo);

            prev2 = prev1;
            prev1 = curr;
        }

        return curr;

    }

    public static void main(String[] args) {
        int height[]={30,10,60,10,60,50};
        int n=height.length;
        System.out.println(frogJump(n, height));
        
    }

}
