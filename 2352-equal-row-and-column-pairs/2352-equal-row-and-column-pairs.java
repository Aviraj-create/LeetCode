import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        Map<Integer, int[]> row_map = new HashMap<>();
        int i = 0;
        for (int[] temp : grid) {
            row_map.put(i, temp);
            i++;
        }
        
        Map<Integer, int[]> col_map = new HashMap<>();
        for (int j = 0; j < grid.length; j++) {
            int[] temp2 = new int[grid.length];
            for (int k = 0; k < grid.length; k++) {
                temp2[k] = grid[k][j];
            }
            col_map.put(j, temp2);
        }
        
        int count = 0;
        for (Map.Entry<Integer, int[]> entry1 : row_map.entrySet()) {
            for (Map.Entry<Integer, int[]> entry2 : col_map.entrySet()) {
                if (Arrays.equals(entry1.getValue(), entry2.getValue())) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
