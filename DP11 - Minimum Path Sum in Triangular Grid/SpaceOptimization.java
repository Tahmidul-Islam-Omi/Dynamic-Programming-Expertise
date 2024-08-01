public class SpaceOptimization {
    public static int minimumPathSum(int[][] triangle, int n) {
        
        int [] next = new int[n];

        for(int i=0; i<triangle[n-1].length; i++) {
            next[i] = triangle[n-1][i];
        }

        int [] curr = new int[n];

        for(int row = n-2; row >= 0; row--) {

            for(int col=row; col>=0; col--) {
                curr[col] = Math.min ( triangle[row][col] + next[col] ,  triangle[row][col] + next[col+1]);
            }

            System.arraycopy(curr, 0, next, 0, row + 1);
        }

        return next[0];
    }

    public static void main(String args[]) {
        int triangle[][] = {{2},
                            {3, 4},
                            {6, 5, 7},
                            {4, 1, 8, 3}};

       

        int n = triangle.length;
        System.out.println(minimumPathSum(triangle, n));
    }
}

// 2 
// 3 4
// 6 5 7
// 4 1 8 3