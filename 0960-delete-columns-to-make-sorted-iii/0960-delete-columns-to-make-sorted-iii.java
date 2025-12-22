class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length;
        int cols = A[0].length();
        
        int[] dp = new int[cols];
        int max = 1;

        // Each column alone is valid
        for (int j = 0; j < cols; j++) {
            dp[j] = 1;
        }

        for (int j = 0; j < cols; j++) {
             for (int i = 0; i < j; i++) {
                if (isValid(A, i, j, rows)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        return cols - max;
    }

    private boolean isValid(String[] A, int i, int j, int rows) {
        for (int r = 0; r < rows; r++) {
            if (A[r].charAt(i) > A[r].charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
