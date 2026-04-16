import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 0;

        for (int num = 1; num <= n && i < target.length; num++) {
            res.add("Push");

            if (num == target[i]) {
                i++;
            } else {
                res.add("Pop");
            }
        }

        return res;
    }
}