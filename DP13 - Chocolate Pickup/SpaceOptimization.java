import java.util.Arrays;

public class SpaceOptimization {
    public static int maximumChocolates(int r, int c, int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int [][] temp = new int [col][col];
        int [][] curr = new int [col][col];

        for(int [] row2 : temp) {
            Arrays.fill(row2, -1);
        }

        for(int i=0; i<col; i++) {
            for(int j=0; j<col; j++) {
                if(i == j) {
                    temp[i][j] = grid[row-1][i];
                }

                else {
                    temp[i][j] = grid[row-1][i] + grid[row-1][j];
                }
            }
        }

        for(int i=row-2; i>=0; i--) {
            for(int j=0; j< col; j++) {
                for(int k=0; k<col; k++) {

                    int ans = Integer.MIN_VALUE;

                    for(int di=-1; di<=1; di++) {
                        for(int dj=-1; dj<=1; dj++) {
                            if( !(di + j < 0 || di+j >= col || dj+k < 0 ||  dj+k >= col) ) {
                                if( j == k) {
                                    ans = Math.max(ans , grid[i][j] + temp[di+j][dj+k]); 
                                }
                                else {
                                    ans = Math.max(ans , grid[i][j] + grid[i][k] + temp[di+j][dj+k]);
                                }
                            }
                        }
                    }

                    curr[j][k] = ans;
                }
            }

            for (int m = 0; m < col; m++) {
                for (int n = 0; n < col; n++) {
                    temp[m][n] = curr[m][n];
                }
            }
            
        }

        return temp[0][col-1];

    }
}
