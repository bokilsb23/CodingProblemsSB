package com.sb.problems.trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
     val = x;
     left=null;
     right=null;
    }


    static TreeNode insert (TreeNode root, int x) {
        if(root == null) {
            return new TreeNode(x);
        }

        if(x < root.val) {
            root.left = insert(root.left, x);
        }
        else {
            root.right = insert(root.right, x);
        }
        return root;
    }
}
