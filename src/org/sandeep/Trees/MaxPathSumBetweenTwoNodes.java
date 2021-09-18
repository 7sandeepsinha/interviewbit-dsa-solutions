package org.sandeep.Trees;

public class MaxPathSumBetweenTwoNodes {
    static int  global_max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode A) {
        int ans = maxPathHelper(A);
        return Math.max(ans, global_max);
    }

    public static int maxPathHelper(TreeNode A){
        if(A == null){
            return 0;
        }

        int lAns = maxPathHelper(A.left);
        int rAns = maxPathHelper(A.right);

        int ans1 = lAns + A.data;
        int ans2 = rAns + A.data;
        int ans3 = A.data;
        int ans4 = lAns + A.data + rAns;

        global_max = Math.max(global_max, Math.max(Math.max(ans1,ans2), Math.max(ans3,ans4)));

        return Math.max(Math.max(lAns,rAns),0) + A.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(maxPathSum(root));


    }
}
