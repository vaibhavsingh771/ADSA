class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long zeros=0;

        for(int i=0; i<nums.length; i++){
            if (nums[i] == 0) {
                zeros++;
                count += zeros;
            } else {
                zeros = 0;
            }
        }
        return count;
    }
}