class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int total = 0;
        for (int a : apple) total += a;

        Arrays.sort(capacity); 

        int used = 0;
        for (int i = capacity.length - 1; i >= 0 && total > 0; i--) {
            total -= capacity[i];
            used++;
        }

        return used;
    }
}
