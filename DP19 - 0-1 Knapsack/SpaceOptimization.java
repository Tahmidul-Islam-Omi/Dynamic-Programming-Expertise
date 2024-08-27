public class SpaceOptimization {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[] temp = new int[maxWeight + 1];
        int[] curr = new int[maxWeight + 1]; 

        for(int w=0; w<= maxWeight; w++) {
            if(weight[0] <= w) {
                temp[w] = value[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (weight[ind] <= w) {
                    curr[w] = Math.max(value[ind] + temp[w - weight[ind]], temp[w]);
                }

                else {
                    curr[w] = temp[w];
                }
            }
            
            for(int i=0; i<=maxWeight; i++) {
                temp[i] = curr[i];
            }
        }

        return temp[maxWeight];
    }
}
