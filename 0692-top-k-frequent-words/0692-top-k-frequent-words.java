  class Pair {
    String s;
    int freq;
public Pair(String s, int freq) {
        this.s = s;
        this.freq = freq;
    }
}

class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        List<String> res = new ArrayList(map.keySet());
        
        Collections.sort(res, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return res.subList(0,k);
       
    }
}