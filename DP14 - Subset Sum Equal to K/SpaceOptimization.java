public class SpaceOptimization {
    public static boolean subsetSumToK(int n, int k, int arr[]) {

        int[] temp = new int[k + 1];
        int[] curr = new int[k + 1];

        temp[0] = 1;

        if (arr[0] <= k) {
            temp[arr[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            
            for (int target = 0; target <= k; target++) {

                int notTake = temp[target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = temp[target - arr[ind]];
                }

                if (take == 1 || notTake == 1) {
                    curr[target] = 1;
                }

                else {
                    curr[target] = 0;
                }
            }

            for (int i = 0; i < curr.length; i++) {
                temp[i] = curr[i];
            }

        }

        if (temp[k] == 1) {
            return true;
        }

        else {
            return false;
        }
    }
}
