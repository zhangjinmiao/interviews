package com.jimzhang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTreeDemo {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    static ArrayList<Integer> list = new ArrayList<>();


    /**
     * 递归
     * 前序遍历：中 → 左 → 右
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        // 中
        list.add(root.val);
        // 左
        if (root.left != null) {
            preOrderTraversal(root.left);
        }
        // 右
        if (root.right != null) {
            preOrderTraversal(root.right);
        }
        return list;
    }



    /**
     * 递归
     * 中序遍历：左 → 中 → 右
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        // 左
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        // 中
        list.add(root.val);
        // 右
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
        return list;
    }

    /**
     * 递归
     * 后序遍历：左 → 右 → 中
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        // 左
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
        // 右
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        // 中
        list.add(root.val);
        return list;
    }


    public static void main(String[] args) {
        /**
         *        1
         *    2      6
         *  3  5    7 8
         *   4
         */
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);

        root.left = left;
        root.right = right;

        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(5);

        left.left = ll;
        left.right = lr;

        TreeNode llr = new TreeNode(4);
        ll.right = llr;

        right.left = new TreeNode(7);
        right.right = new TreeNode(8);


//        preOrderTraversal(root); // 1 2 3 4 5 6 7 8
//          inOrderTraversal(root);  // 3 4 2 5 1 7 6 8
        postOrderTraversal(root);  // 4 3 5 2 7 8 6 1
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
