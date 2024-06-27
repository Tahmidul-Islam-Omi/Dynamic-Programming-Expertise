public class SpaceOptimization {
    public static int uniquePaths(int m, int n) {

        int [] prev = new int[n];

        for (int row = 0; row < m; row++) {

            int [] curr = new int[n];

            for (int col = 0; col < n; col++) {

                if (row == 0 && col == 0) {
                    curr[col] = 1;
                }

                else if (row > 0 && col > 0) {

                    curr[col] = prev[col] + curr[col-1];
                }

                else if (row > 0 && col == 0) {

                    curr[col] = prev[col];
                }

                else if (col > 0 && row == 0) {
                    curr[col] = curr[col-1];
                }

            }

            prev = curr;
        }

        return prev[n-1];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4,4));
    }
}