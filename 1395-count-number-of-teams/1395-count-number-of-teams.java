class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            int leftSmaller =0, leftGreater = 0;
            int rightSmaller =0, rightGreater = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmaller++;
                else leftGreater++;
            }

            for (int k = j+1; k < n; k++) {
                if (rating[k] < rating[j]) rightSmaller++;
                else rightGreater++;
            }

            count += leftSmaller * rightGreater; 
            count += leftGreater * rightSmaller; 
        }

        return count;
    }
}