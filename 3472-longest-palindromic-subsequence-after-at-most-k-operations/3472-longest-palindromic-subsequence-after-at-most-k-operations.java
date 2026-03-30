class Solution {
    int[][][] dp;

    public int longestPalindromicSubsequence(String s, int K) {
        int n = s.length();
        dp = new int[n][n][K + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return solve(s, 0, n - 1, K);
    }

    private int solve(String s, int i, int j, int k) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        int res = Math.max(
            solve(s, i + 1, j, k),
            solve(s, i, j - 1, k)
        );

        int cost = getCost(s.charAt(i), s.charAt(j));

        if (k >= cost) {
            res = Math.max(res,
                2 + solve(s, i + 1, j - 1, k - cost)
            );
        }

        return dp[i][j][k] = res;
    }

    private int getCost(char a, char b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 26 - diff);
    }
}