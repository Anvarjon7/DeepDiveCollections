package org.example.graphsAndTrees.trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public class MinimalBST {

        public TreeNode createMinimalBST(int[] arr) {
            return createMinimalBST(arr, 0, arr.length - 1);
        }


        static TreeNode createMinimalBST(int[] arr, int start, int end) {
            if (end < start) return null;

            int mid = (start + end) / 2;
            TreeNode n = new TreeNode(arr[mid]);
            n.left = createMinimalBST(arr, start, mid - 1);
            n.right = createMinimalBST(arr, mid + 1, end);

            return n;
        }
    }

    static class ListOfDepth {

        public static void main(String[] args) {

//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(2);
//            root.right = new TreeNode(3);
//            root.left.left = new TreeNode(4);
//            root.left.right = new TreeNode(5);
//            root.right.left = new TreeNode(6);
//            root.right.right = new TreeNode(7);
//
//            List<ListNode> lists = createLevelLinkedList(root);
//
//
//            int depth = 0;
//
//            for (ListNode head : lists) {
//                System.out.print("Depth " + depth + ": ");
//                while (head != null) {
//                    System.out.print(head.val + " ");
//                    head = head.next;
//                }
//                System.out.println();
//                depth++;
//            }

//            System.out.println(countOnes(13));

            String allowed = "ab"; String[] words = {"ad","bd","aaab","baa","badab"};
            System.out.println(count(allowed,words));


        }


        public static List<ListNode> createLevelLinkedList(TreeNode root) {
            List<ListNode> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }

            while (!queue.isEmpty()) {
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

        static boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
        }

        private static int checkHeight(TreeNode node) {
            if (node == null) return -1;

            int leftHeight = checkHeight(node.left);
            if (leftHeight == -1) return -1;

            int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(rightHeight - leftHeight) > 1) return -1;

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    private static int countOnes(int num){
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            boolean isSet = (num & (1 << i)) != 0;
            counter += isSet ? 1 : 0;
        }

        return counter;
    }

    private static int count(String allowed, String[] words){
        int count = 0;
        int allowedMasks = 0;
        for(char c : allowed.toCharArray()){
            allowedMasks |= 1 << (c - 'a');
        }
        for (String word : words){
            int wordMasks = 0;
            for (char c : word.toCharArray()){
                wordMasks |= 1 << (c - 'a');
            }
            if ((wordMasks & ~allowedMasks) == 0) {
                count++;
            }
        }
    return count;
    }

    private static int flipBits(int n){
        int maxLen = 1;
        int curr = 0;
        int prev = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0){
                curr++;
            }else {
                maxLen = Math.max(maxLen, prev + 1 + curr);
                prev = curr;
                curr = 0;
            }
        }

        maxLen = Math.max(maxLen, prev + 1 + curr);
        return maxLen;
    }
}
