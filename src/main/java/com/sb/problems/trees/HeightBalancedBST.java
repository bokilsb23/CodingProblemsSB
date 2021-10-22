package com.sb.problems.trees;

public class HeightBalancedBST {

    private static boolean isBalanced(TreeNode root, NodeHeight nodeHeight) {
        if(root == null) {//Terminating condition, occurs when we try to find the height of leaf's children
            nodeHeight.height = 0;
            return true;
        }


        NodeHeight leftHeight = new NodeHeight();
        NodeHeight rightHeight = new NodeHeight();

        boolean isLeftBalanced = isBalanced(root.left, leftHeight);
        boolean isRightBalanced = isBalanced(root.right, rightHeight);

        nodeHeight.height = Math.max(leftHeight.height, rightHeight.height) + 1;//The height of node will be max of height of left and right subtrees, plus 1

        if(Math.abs(leftHeight.height - rightHeight.height) > 1) {//If at any stage, left and right has height difference more than 1, return false
            return false;
        }
        else {
            return isLeftBalanced && isRightBalanced;//If both left and right sub trees are balanced, then the current node is balanced
        }
    }

    private static boolean isTreeBalanced(TreeNode root) {
        return isBalanced(root, new NodeHeight());
    }

    public static void main(String args[])
    {

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        if (isTreeBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }


    static class NodeHeight {
        int height;
    }
}
