import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j && (s.charAt(i) == ' ' || s.charAt(j) == ' ')) {
            if (s.charAt(i) == ' ') {
                i++;
            }
            if (s.charAt(j) == ' ') {
                j--;
            }
        }

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            st.push(s.charAt(i));
            i++;
        }

        StringBuilder sb1 = new StringBuilder();
        while (!st.isEmpty()) {
            if (st.peek() != ' ') {
                sb.append(st.pop());
            } else {
                sb.reverse();
                sb1.append(sb.toString());

                // Skip consecutive spaces
                while (!st.isEmpty() && st.peek() == ' ') {
                    st.pop();
                }

                // Append a single space after the word
                sb1.append(' ');

                sb.setLength(0);
            }
        }

        sb.reverse();
        sb1.append(sb.toString());

        return sb1.toString();
    }
}
