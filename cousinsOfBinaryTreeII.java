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
    public Map<Integer,Integer> levelSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>(); 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level =0;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum =0;
            for(int i=0;i<size;i++) {
                TreeNode curNode = q.peek();
                q.poll();
                sum += curNode.val;
                if(curNode.left!=null)
                    q.offer(curNode.left);
                if(curNode.right!=null)
                    q.offer(curNode.right);
            }
            map.put(level,sum);
            level++;
        }
        return map;
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer,Integer> map = levelSum(root);
        dfs(map,root,0,0);
        System.out.println(map);
        return root;
    }

    public void dfs(Map<Integer,Integer> map,TreeNode root,int level,int siblingVal) {
        if(root==null)
            return ;
        int leftSiblingVal = (root.left!=null) ? root.left.val : 0;
        int rightSiblingVal = (root.right!=null) ? root.right.val : 0;
        int totalSum = map.get(level);
        dfs(map,root.left,level+1,rightSiblingVal);
        dfs(map,root.right,level+1,leftSiblingVal);
        root.val = totalSum - siblingVal - root.val;   
    }
}
