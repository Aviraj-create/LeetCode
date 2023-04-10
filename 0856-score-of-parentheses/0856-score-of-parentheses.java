class Solution {
    public int scoreOfParentheses(String s) {
       int curr=0;
        Stack<Integer>st=new Stack();
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                st.push(curr);
                curr=0;
            }
            else
            {
                curr=st.pop()+Math.max(curr*2,1);
            }
        }
        
        return curr;
        
    }
}