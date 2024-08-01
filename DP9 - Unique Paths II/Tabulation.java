import java.util.ArrayList;
import java.util.Arrays;

public class Tabulation {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[] temp = new int[m];
        int[] ans = new int[m];

        temp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (mat.get(0).get(1) != -1) {
                temp[i] = temp[i - 1];
            }

            else {
                temp[i] = 0;
            }
        }

        for(int i=1)

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        list.add(new ArrayList<>(Arrays.asList(0, -1, 0)));
        list.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        System.out.println(mazeObstacles(3, 3, list));
    }
}
