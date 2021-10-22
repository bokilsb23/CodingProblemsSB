package com.sb.problems.trees;

public class KthSmallestElementInTree {

    private static int count;
    public static void main(String[] args) {
        int[] str = new int[]{1,2,3};
        TreeNode root=null;
        for (int i:str) {
            root = TreeNode.insert(root, i);
        }
        System.out.println(kthSmallestElement(root, 2));

        System.out.println(kthSmallestElement(createBstFromArray(new int[]{20, 8, 22, 4, 12, 10, 14}), 3));
    }


    // INORDER TRAVERSAL TILL Kth element is found (Inorder traversal traverses tree in ascending order)
    private static TreeNode kthSmallestNode(TreeNode A, int B) {
        if(A == null) {
            return null;
        }
        TreeNode leftValue = kthSmallestNode(A.left, B);
        if(leftValue != null) {
            return leftValue;
        }

        count++;
        if(count == B) {
            return A;
        }

        return kthSmallestNode(A.right, B);
    }

    private static int kthSmallestElement(TreeNode A, int B) {
        count = 0;
        return kthSmallestNode(A, B).val;
    }

    private static TreeNode createBstFromArray(int[] arr) {
        TreeNode root = null;
        for(int i : arr) {
            root = TreeNode.insert(root, i);
        }
        return root;
    }




}
