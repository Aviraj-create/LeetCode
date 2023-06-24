class Solution {
    public static int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int i : rods) sum += i;
        Integer dp[][] = new Integer[sum ][rods.length + 1];
        return find(rods,0,0,dp)/2;
    }
    public static int find(int arr[], int sum1, int idx, Integer dp[][]) {
        if (idx >= arr.length) {
            if (sum1 == 0) return 0;
            return -1000000;
        }
        if (dp[Math.abs(sum1)][idx] != null) return dp[Math.abs(sum1)][idx];
        int way1 = find(arr, sum1 + arr[idx], idx + 1, dp);
        int way2 = find(arr, sum1 - arr[idx], idx + 1, dp);
        int way3 = find(arr, sum1, idx + 1, dp);
        return dp[Math.abs(sum1)][idx] = Math.max(arr[idx] + way1, Math.max(arr[idx] + way2, way3));
    }
}