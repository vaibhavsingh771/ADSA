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

class CBTInserter {

    private TreeNode root;
    private Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();

        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();

            if (node.left == null || node.right == null) {
                q.offer(node);
            }

            if (node.left != null) temp.offer(node.left);
            if (node.right != null) temp.offer(node.right);
        }
    }
    
    public int insert(int val) {
        TreeNode parent = q.peek();
        TreeNode newNode = new TreeNode(val);

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            q.poll(); 
        }

        q.offer(newNode);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */