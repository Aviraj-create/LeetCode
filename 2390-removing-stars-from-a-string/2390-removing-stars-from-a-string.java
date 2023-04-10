class Solution {
    public String removeStars(String s) {
        Stack<Character>st=new Stack();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='*')st.push(s.charAt(i));
            else
            {
                st.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.empty())
        {
            sb.append(st.peek());
            st.pop();
        }
        StringBuilder sb1=sb.reverse();
        String s1=sb1.toString();
        return s1;
    }
}