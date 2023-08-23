class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new Pair((char)(i + 'A'), arr[i], 0));
            }
        }
        
        int t = 0;
        while (!pq.isEmpty()) {
           
            
            if(t>=pq.peek().time){
                
            Pair temp=pq.poll();
            // System.out.println(temp.ch);
            t++;
            temp.f--;
            temp.time = temp.time + n+1;
                
            if (temp.f > 0) {
                pq.add(temp);
            
            }
                
            }
            else
               {
                // System.out.println('*');
                t++;
                
            }
            
        }
        
        return t;
    }
}

class Pair {
    char ch;
    int f;
    int time;
    
    public Pair(char ch, int f, int time) {
        this.ch = ch;
        this.f = f;
        this.time = time;
    }
}
