import java.util.*;

public class Solution {

    public void solve(int i, int n, int k, List<Integer> temp, List<List<Integer>> ans) {
        
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i > n) return;

        temp.add(i);
        solve(i + 1, n, k, temp, ans);

        temp.remove(temp.size() - 1);

        solve(i + 1, n, k, temp, ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(1, n, k, temp, ans);
        return ans;
    }
}
