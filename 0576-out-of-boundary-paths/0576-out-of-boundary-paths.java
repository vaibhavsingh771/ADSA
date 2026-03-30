class Solution {
    int MOD = 1_000_000_007;
    int[][][] dp;
    int m, n;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        dp = new int[m][n][maxMove + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int r, int c, int k) {
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        if (k == 0) return 0;

        if (dp[r][c][k] != -1) return dp[r][c][k];

        long res = 0;

        res += dfs(r + 1, c, k - 1);
        res += dfs(r - 1, c, k - 1);
        res += dfs(r, c + 1, k - 1);
        res += dfs(r, c - 1, k - 1);

        return dp[r][c][k] = (int)(res % MOD);
    }
}