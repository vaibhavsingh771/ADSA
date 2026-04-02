public class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        int sumPiles = 0;
        for (List<Integer> pile : piles) {
            int n = pile.size();
            sumPiles = Math.min(k, sumPiles + n);
            for (int j = sumPiles; j >= 0; j--) {
                int currentSum = 0;
                for (int coin = 1; coin <= Math.min(j, n); coin++) {
                    currentSum += pile.get(coin - 1);
                    dp[j] = Math.max(dp[j], dp[j - coin] + currentSum);
                }
            }
        }
        return dp[k];
    }
}