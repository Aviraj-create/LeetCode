class Solution {
    public int scoreOfParentheses(String s) {
//        int curr=0;
//         Stack<Integer>st=new Stack();
//         for(char c:s.toCharArray())
//         {
//             if(c=='(')
//             {
//                 st.push(curr);
//                 curr=0;
//             }
//             else
//             {
//                 curr=st.pop()+Math.max(curr*2,1);
//             }
//         }
        
//         return curr;
        
        Stack<Integer>st=new Stack();
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                st.push(-1);
            }
            else
            {
                int curr=0;
                
                while(st.peek()!=-1)
                      {
                          curr+=st.pop();
                      }
                      st.pop();
                      st.push((curr==0)?1:curr*2);
                    
            }
        }
        
        int sum=0;
        while(!st.empty())
        {
            sum+=st.pop();
        }
        
        return sum;
        
    }
}