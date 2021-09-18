package org.sandeep.Trees;

import java.util.ArrayList;

public class PrintPathSum {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> aux = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        recurse(A, B, 0);
        return result;
    }

    void recurse(TreeNode A, int B, int sum){

        if(A==null) return;

        aux.add(A.data);

        if(A.left==null && A.right==null && sum+A.data==B)
        {
            result.add(new ArrayList<>(aux));
        }
        else{
            recurse(A.left, B, sum+A.data);
            recurse(A.right, B, sum+A.data);
        }
        aux.remove(aux.size()-1);

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(8);

        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(-2);

        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(1);

        PrintPathSum p = new PrintPathSum();
        System.out.println(p.pathSum(t,18));

    }
}
