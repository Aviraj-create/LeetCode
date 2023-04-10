class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>st=new Stack();
        for(int i=0;i<s.length();i++)
        {
            if(st.empty()) st.push(s.charAt(i));
            else
            {
                if(st.peek()==s.charAt(i))
                {
                    st.pop();
                }
                else
                {
                    st.push(s.charAt(i));
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.empty())
        {
            sb.append(st.peek());
            st.pop();
        }
        
        StringBuilder sb1=sb.reverse();
        String s1=sb.toString();
        return s1;
    }
}