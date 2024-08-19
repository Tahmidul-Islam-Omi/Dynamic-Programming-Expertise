import java.util.Arrays;

public class SpaceOptimization {
    public static int getMaxPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] prev = new int[col];
        int[] curr = new int[col];

        for (int i = 0; i < col; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < row; i++) {

            int upLeft = (int) Math.pow(-10,9);
            int up = (int) Math.pow(-10, 9);
            int upRight = (int) Math.pow(-10, 9);

            for(int j=0; j<col; j++) {

                if(j>=1) {
                    upLeft = matrix[i][j] + prev[j-1];
                }

                up = matrix[i][j] + prev[j];

                if(j+1 < col) {
                    upRight = matrix[i][j] + prev[j+1];
                }

                curr[j] = Math.max ( Math.max(upLeft,upRight) , up );
            }

            prev = Arrays.copyOf(curr, curr.length);
        }

        int maxPathSum = (int) Math.pow(-10, 9);

        for (int j = 0; j < col; j++) {
            maxPathSum = Math.max(maxPathSum, prev[j]);
        }

        return maxPathSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { -9999},
        };
        System.out.println(getMaxPathSum(matrix));
    }
}
