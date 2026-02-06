class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n =nums.length;
        int i=0, j=0;
        int ans =0;
        TreeMap<Integer, Integer> map= new TreeMap<>();

        while (j<n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            int maxVal = map.lastKey();
            int minVal = map.firstKey();

            while((maxVal-minVal)> limit){
                map.put(nums[i], map.get(nums[i]) - 1);

                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;

                if(!map.isEmpty()) {
                    maxVal = map.lastKey();
                    minVal =map.firstKey();
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;

    }
}