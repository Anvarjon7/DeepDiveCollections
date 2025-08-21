package org.example.graphsAndTrees.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

static class ListNode{
        int val;
        ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
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

static class ListOfDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<ListNode> lists = createLevelLinkedList(root);


        int depth = 0;

        for(ListNode head : lists){
            System.out.print("Depth " + depth + ": ");
            while (head != null){
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
            depth++;
        }
    }


        public static List<ListNode> createLevelLinkedList(TreeNode root){
            List<ListNode> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null){
                queue.add(root);
            }

            while (!queue.isEmpty()){
                int levelSize = queue.size();
                ListNode dummyHead = new ListNode(0);
                ListNode current = dummyHead;

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    current.next = new ListNode(node.val);
                    current = current.next;

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }

                result.add(dummyHead.next);
            }

            return result;
        }
}
}
