class Solution {
    int i = 0;

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } 
            else if (c == '[') {
                String sub = decodeString(s);
                while (num-- > 0) res.append(sub);
                num = 0;
            } 
            else if (c == ']') {
                break;
            } 
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
