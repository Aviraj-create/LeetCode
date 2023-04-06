class Solution {
    public String addStrings(String num1, String num2) {
        int i=0;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i<num1.length() || i<num2.length())
        {
            int x=(i<num1.length())?num1.charAt(num1.length()-i-1)-'0':0;
            int y=(i<num2.length())?num2.charAt(num2.length()-i-1)-'0':0;
            sb.append((char)((x+y+carry)%10+'0'));
            carry=(x+y+carry)/10;
            i++;
        }
        if(carry!=0)
        {
            sb.append((char)(carry+'0'));
        }

        return sb.reverse().toString();
    }
}
