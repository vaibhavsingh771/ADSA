class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int highestPrefix = 0;
        int lowestPrefix = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;
            highestPrefix = Math.max(highestPrefix, sum);
            lowestPrefix = Math.min(lowestPrefix, sum);

            ans = highestPrefix - lowestPrefix;
        }
        return ans;
    }
}