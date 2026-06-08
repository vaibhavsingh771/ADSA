class Solution {
    int[] dp;
    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        dp = new int[s.length()];
        java.util.Arrays.fill(dp, -1);

        return solve(s, 0) - 1;
    }

    int solve(String s, int i) {
        if (i == s.length()) return 0;
        if (dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;

        for (int j=i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + solve(s, j + 1);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min
        ;
    }

}