class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack();
        StringBuilder sb1=new StringBuilder();
        
        for(char ch:s.toCharArray())
        {
            if(ch!=' ')
            {
                sb1.append(ch);
                
            }
            else
            {
                sb1.reverse();
                sb.append(sb1);
                sb.append(' ');
               sb1.setLength(0);
            }
        }
        sb1.reverse();
        sb.append(sb1);
        
        return sb.toString();
        
    }
}