

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return f(nums, -1, 0, dp);
    }

    private int f(int[] nums, int prev, int idx, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }

        if (dp[prev + 1][idx] != -1) {
            return dp[prev + 1][idx];
        }

        int take = 0;
        if (prev < 0 || nums[idx] > nums[prev]) {
            take = 1 + f(nums, idx, idx + 1, dp);
        }

        int notTake = f(nums, prev, idx + 1, dp);

        dp[prev + 1][idx] = Math.max(take, notTake);
        return dp[prev + 1][idx];
    }
}
