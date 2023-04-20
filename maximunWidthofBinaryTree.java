class Pair {
    int index;
    TreeNode node;
    Pair(int index,TreeNode node) {
        this.index = index;
        this.node = node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //use bfs for marking the index...
        //number of node in that level = lastIndex - firstIndex + 1
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        int maxWidth =1;
        while(!q.isEmpty()) {
            int size = q.size();
            int first =0;
            int last = 0;
            for(int i=0;i<size;i++) {
                Pair p = q.peek();
                q.poll();
                int curIndex = p.index;
                TreeNode curNode = p.node;
                if(i==0) {
                    first = curIndex;
                }
                if(i==size-1) {
                    last = curIndex;
                }
                //left child index is 2*parentindex + 1
                if(curNode.left!=null) {
                    q.offer(new Pair(curIndex*2+1,curNode.left));
                }
                //left child index is 2*parentindex + 2
                if(curNode.right!=null) {
                    q.offer(new Pair(curIndex*2+2,curNode.right));
                }
            }
            //at each level calculating the width using the first and last Index...
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}
