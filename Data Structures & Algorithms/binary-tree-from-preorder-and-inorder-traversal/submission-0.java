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
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructBinaryTree(preorder,0,inorder.length-1);
    }

    public TreeNode constructBinaryTree(int[] preorder, int start, int     end){
        if(start>end) return null;
        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);
        node.left=constructBinaryTree(preorder,start,inorderIndex-1);
        node.right=constructBinaryTree(preorder,inorderIndex+1,end);
        return node;
    }
}
