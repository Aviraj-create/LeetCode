class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int curr = 0;
        visited[curr] = true;
        int i = 1;
        while (true) {
            curr = (curr + i * k) % n;
            if (visited[curr]) {
                break;
            }
            visited[curr] = true;
            i++;
        }
        int[] losers = new int[n - i];
        int idx = 0;
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                losers[idx] = j + 1;
                idx++;
            }
        }
        return losers;
    }
}
