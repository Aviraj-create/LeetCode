import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        if (arr.length < 2) return arr;
        int l = arr[0][0];
        int r = arr[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (r < arr[i][0]) {
                ans.add(new int[]{l, r});
                l = arr[i][0];
                r = arr[i][1];
            } else if (r == arr[i][0] || (l <= arr[i][0] && arr[i][0] <= r)) {
                r = Math.max(r, arr[i][1]);
            } else if (l <= arr[i][0] && r >= arr[i][1]) {
                continue;
            }
        }
        ans.add(new int[]{l, r});
        int[][] a = ans.toArray(new int[0][]);
        return a;
    }
}
