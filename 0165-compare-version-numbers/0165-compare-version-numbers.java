class Solution {
    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0;

        while (i < v1.length() || j < v2.length()) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            while (i < v1.length() && v1.charAt(i) != '.') {
                sb1.append(v1.charAt(i));
                i++;
            }

            while (j < v2.length() && v2.charAt(j) != '.') {
                sb2.append(v2.charAt(j));
                j++;
            }

            int temp1 = sb1.length() == 0 ? 0 : Integer.parseInt(sb1.toString());
            int temp2 = sb2.length() == 0 ? 0 : Integer.parseInt(sb2.toString());

            if (temp1 > temp2) return 1;
            else if (temp2 > temp1) return -1;

            
            i++;
            j++;
        }
        return 0;
    }
}
