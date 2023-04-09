class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int visitedCells = curr[2];

            if (i == m - 1 && j == n - 1) { 
                return visitedCells;
            }

            if (visited[i][j] > 0) { 
                continue;
            }
            visited[i][j] = visitedCells; 

            
            for (int k = j + 1; k <= j + grid[i][j] && k < n; k++) {
                if (visited[i][k] == 0) {
                    pq.offer(new int[] {i, k, visitedCells + 1});
                }
            }

            
            for (int k = i + 1; k <= i + grid[i][j] && k < m; k++) {
                if (visited[k][j] == 0) {
                    pq.offer(new int[] {k, j, visitedCells + 1});
                }
            }
        }

        return -1;
    }
}