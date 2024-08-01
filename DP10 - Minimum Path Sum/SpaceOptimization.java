public class SpaceOptimization {
    public static int minSumPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[] prev = new int[col];
        prev[0] = grid[0][0];

        for(int i=1; i<col; i++) {
            prev[i] = prev[i-1] + grid[0][i] ;
        }

        int[] curr = new int[col];

        for(int r=1; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(c == 0) {
                    curr[c] = prev[c] + grid[r][c];
                    continue;
                }
                curr[c] = Math.min( prev[c] + grid[r][c]  , curr[c-1] + grid[r][c]);
            }
            prev = curr;
        }

        return curr[col-1];

    }
}
