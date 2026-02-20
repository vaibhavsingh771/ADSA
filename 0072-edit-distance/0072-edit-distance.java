class Solution {

    private int[][] dp;

    private int match(String s1, String s2, int i, int j) {

        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = match(s1, s2, i + 1, j + 1);
        }

        int insert = match(s1, s2, i, j + 1);      
        int delete = match(s1, s2, i + 1, j);      
        int replace = match(s1, s2, i + 1, j + 1); 

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return match(word1, word2, 0, 0);
    }
}