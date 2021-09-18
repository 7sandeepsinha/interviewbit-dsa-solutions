package org.sandeep.Trees;

public class PathSum {
    boolean result = false;
    public int hasPathSum(TreeNode A, int B) {
        pathSumHelper(A,B,0);
        if(result){
            return 1;
        }else{
            return 0;
        }

    }

    public void pathSumHelper(TreeNode root, int B, int sum){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if((sum + root.data) == B){
                result = true;
            }
        }
        pathSumHelper(root.left,  B, sum + root.data);
        pathSumHelper(root.right, B, sum + root.data);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5 );
        root.left = new TreeNode(1000);
        root.right = new TreeNode(200);
        PathSum p = new PathSum();
        System.out.println(p.hasPathSum(root,1000));
    }
}
