class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        while (low < high) {

            int mid = (low + high) / 2;
            int current= 0;
            int neededDays =1;

            for (int w : weights) {
                if (current + w > mid) {
                    neededDays++;
                    current = 0;
                }
                current += w;
            }
            if (neededDays <= days) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}