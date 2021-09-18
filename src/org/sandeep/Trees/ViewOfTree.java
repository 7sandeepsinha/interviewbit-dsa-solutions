package org.sandeep.Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ViewOfTree {
    static int max_depth = -1;

    public static void leftViewOfTreeWithLevelOrder(TreeNode root){
        if(root == null){
            return;
        }
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        System.out.println(root.data);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                flag = true;
                q.add(null);
                if(q.peek() == null){
                    return;
                }
            }else{
                if(flag){
                    flag = false;
                    System.out.println(curr.data);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void leftViewOfTreeWithDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }

        if(depth > max_depth){
            max_depth = depth;
            System.out.println(root.data);
        }

        leftViewOfTreeWithDepth(root.left , depth + 1 );
        leftViewOfTreeWithDepth(root.right, depth + 1 );
    }

    public static void rightViewOfTreeWithLevelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode prev = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(prev != null)
                    System.out.println(prev.data);
                q.add(null);
                if(q.peek()==null)
                    return;
            }else{
                prev = curr;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    public static void rightViewOfTreeWithDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }

        if(depth > max_depth){
            max_depth = depth;
            System.out.println(root.data);
        }

        rightViewOfTreeWithDepth(root.right, depth + 1 );
        rightViewOfTreeWithDepth(root.left , depth + 1 );
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

        rightViewOfTreeWithLevelOrder(root);
        System.out.println("");
        rightViewOfTreeWithDepth(root,0);

    }
}
