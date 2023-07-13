class Solution {
    
    int[] answer;
    ArrayList<ArrayList<Integer>> adj;
    int N;
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        N=n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            adj.get(path[0]-1).add(path[1]-1);
            adj.get(path[1]-1).add(path[0]-1);
        }

        answer = new int[n];
        
        back(0);
        return answer;
       
    }
    
    boolean back(int n)
    {
        if(n==N)
        {
            return true;
        }
        
        for(int i=1;i<=4;i++)
        {
            if(isValid(n,i))
            {
                answer[n]=i;
                
                if(back(n+1))
                {
                    return true;
                }
            }
           
        }
         return false;
    }

    

    boolean isValid(int curr, int col) {
        for (int i : adj.get(curr)) {
            if (col == answer[i]) {
                return false;
            }
        }
        return true;
    }
}
