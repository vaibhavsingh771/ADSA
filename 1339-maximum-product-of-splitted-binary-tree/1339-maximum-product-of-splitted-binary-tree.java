/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long total = 0, max = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        total = treeSum(root);   // Step 1: total sum
        dfs(root);               // Step 2: try all splits
        return (int)(max % MOD);
    }

    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);
        long sub = left + right + node.val;

        max = Math.max(max, sub * (total - sub));
        return sub;
    }
}
