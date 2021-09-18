package org.sandeep.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    static TreeNode prev, curr, leftMost;

    public static TreeNode populateWithLevelOrder(TreeNode root){
        if(root == null){
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                q.add(null);
                if(q.peek() == null)
                    return root;
            }else{
                if(curr.left != null ){
                    q.add(curr.left);
                }
                if(curr.right != null ){
                    q.add(curr.right);
                }
                curr.next = q.peek();
            }
        }
        return root;
    }

    public static void populateWithoutLevelOrder(TreeNode root){
        if(root == null)
            return;

        leftMost = root;
        curr = leftMost;

        while(leftMost != null){
            prev = null;
            curr = leftMost;

            leftMost = null;

            while(curr != null){
                processChild(curr.left);
                processChild(curr.right);
                curr = curr.next;
            }
        }

    }

    public static void processChild(TreeNode childNode){
        if(childNode != null){
            if (prev != null) {
                prev.next = childNode;
            }else{
                leftMost = childNode;
            }
            prev = childNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        populateWithoutLevelOrder(root);
    }
}
