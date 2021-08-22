package org.sandeep.Trees;

public class TreeHeight {

    public static int getTreeHeight(TreeNode root){
        if(root == null)
            return 0;

        int lstH = getTreeHeight(root.left);
        int rstH = getTreeHeight(root.right);

        return Math.max(lstH,rstH) + 1;
    }

    public static boolean isBalanceBinary(TreeNode root){
        if(root == null)
            return true;

        int lstH = getTreeHeight(root.left);
        int rstH = getTreeHeight(root.right);

        if(Math.abs(lstH-rstH) < 2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.left.left.right.left = new TreeNode(9);
        root.left.left.right.right = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        TreeNode skewedRoot = new TreeNode(1);
        skewedRoot.left = new TreeNode(2);
        skewedRoot.left.left = new TreeNode(3);
        skewedRoot.left.left.left = new TreeNode(4);
        skewedRoot.left.left.left.left = new TreeNode(5);

        System.out.println(getTreeHeight(skewedRoot));
        System.out.println(isBalanceBinary(skewedRoot));
    }
}
