import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        k--;
        for (int i = 0; i < weights.length - 1; i++) {
            pq1.add(weights[i] + weights[i + 1]);
            pq2.add(weights[i] + weights[i + 1]);
            if (pq1.size() > k) {
                pq1.poll();
                pq2.poll();
            }
        }
        long ans1 = 0, ans2 = 0;
        while (!pq1.isEmpty()) {
            ans1 += pq1.peek();
            ans2 += pq2.peek();
            pq1.poll();
            pq2.poll();
        }
        return Math.abs(ans2 - ans1);
    }
}
