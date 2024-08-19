	public static int getMaxPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

		int [][] dp = new int[row][col];

        for(int i=0; i<col; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<row; i++) {

            int upLeft = (int) Math.pow(-10,9);
            int up = (int) Math.pow(-10,9);
            int upright = (int) Math.pow(-10,9);

            for(int j=0; j<col; j++) {
                if(j-1 >= 0) {
                    upLeft = matrix[i][j] + dp[i-1][j-1];
                }
                up = matrix[i][j] + dp[i-1][j];
                if(j+1 <= (col-1)) {
                    upright = matrix[i][j] + dp[i-1][j+1];
                }
                System.out.println(upLeft + " " + up + " " + upright);
                dp[i][j] = Math.max( Math.max(upLeft , up) , upright);
                System.out.println("i " + i + " j " + j + " " + dp[i][j]);
            }
        }

        int maxPathSum = (int) Math.pow(-10,9);

        for(int j=0; j<col; j++) {
            maxPathSum = Math.max(maxPathSum , dp[row-1][j]);
        }

        return maxPathSum;
	}

    public static void main(String[] args) {
        int [][] matrix = {
            {-9999, -97475, -9585},
            {0,0,0},
            {-90 , 10 , 10}
        };
        System.out.println(getMaxPathSum(matrix));
    }