
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {

                TreeNode current = q.poll();
                list.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
