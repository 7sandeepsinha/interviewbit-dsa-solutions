package org.sandeep.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {
    public static TreeNode merge(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null){
            return null;
        }
        if(rootA == null) return rootB;
        if(rootB == null) return rootA;

        TreeNode left = merge(rootA.left, rootB.left);
        TreeNode right = merge(rootA.right, rootB.right);
        TreeNode n = new TreeNode(rootA.data + rootB.data);
        n.left = left;
        n.right = right;
        return n;
    }



    public static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(1);
        rootA.left = new TreeNode(2);
        rootA.left.left = new TreeNode(4);
        rootA.right = new TreeNode(3);

        TreeNode rootB = new TreeNode(2);
        rootB.left = new TreeNode(4);
        rootB.left.right = new TreeNode(2);
        rootB.right = new TreeNode(1);
        rootB.right.right = new TreeNode(3);

        levelOrderTraversal(merge(rootA,rootB));

    }


}
