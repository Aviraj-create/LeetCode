class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> st=new ArrayDeque<>();
        int[]lastOcc=new int[26];
        boolean[]visited=new boolean[26];
        
        
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            lastOcc[s.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(visited[c-'a'])continue;
            while(!st.isEmpty() && st.peek()>c && lastOcc[st.peek()-'a']>i)
            {
                visited[st.peek()-'a']=false;
                st.pop();
            }
            visited[c-'a']=true;
            st.push(c);
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pollLast());
            
        }
        
        return sb.toString();
    }
}