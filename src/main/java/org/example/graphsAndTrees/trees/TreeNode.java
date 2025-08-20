package org.example.graphsAndTrees.trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

public class MinimalBST {

        public TreeNode createMinimalBST(int[] arr){
            return createMinimalBST(arr, 0, arr.length - 1);
        }


        static TreeNode createMinimalBST(int[] arr, int start,int end) {
            if (end < start) return null;

            int mid = (start + end) / 2;
            TreeNode n = new TreeNode(arr[mid]);
            n.left = createMinimalBST(arr, start, mid -1);
            n.right = createMinimalBST(arr, mid + 1, end);

            return n;
        }
}
}
