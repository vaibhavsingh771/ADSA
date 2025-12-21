class Solution {
    //VAIBHAV
    public String longestPalindrome(String s) {
        int n = s.length(), l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            for (int a = i, b = i; a >= 0 && b < n && s.charAt(a) == s.charAt(b); a--, b++)
                if (b - a > r - l) { l = a; r = b; }
            for (int a = i, b = i + 1; a >= 0 && b < n && s.charAt(a) == s.charAt(b); a--, b++)
                if (b - a > r - l) { l = a; r = b; }
        }
        return s.substring(l, r + 1);
    }
}
