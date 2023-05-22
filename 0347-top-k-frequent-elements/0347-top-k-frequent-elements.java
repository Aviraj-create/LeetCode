import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue()); // Modified comparator
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            pq.offer(p);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Pair temp = pq.poll();
            ans[i] = temp.getKey();
        }

        return ans;
    }
}
