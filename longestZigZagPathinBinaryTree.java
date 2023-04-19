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
    int maxi = Integer.MIN_VALUE;
    void func(TreeNode root,boolean flag,int len) {
        if(root==null)
            return ;
        maxi = Math.max(len,maxi);
        //can go left child...
        if(flag) {  
            func(root.left,false,len+1);
            func(root.right,true,1);
        }
        // can go to right child....
        else {
            func(root.right,true,len+1);
            func(root.left,false,1);
        }
        return ;
    }
    public int longestZigZag(TreeNode root) {
        func(root.left,false,1);
        func(root.right,true,1);
        maxi = (maxi == Integer.MIN_VALUE) ? 0 : maxi;
        return maxi;
    }
}
