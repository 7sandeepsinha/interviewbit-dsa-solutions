package org.sandeep.Trees;

import java.util.HashMap;

public class CheckTreeTraversals {
    public int postIndex = 0;
    public int preIndex = 0;
    public int result = 1;



    public int solve(int[] A, int[] B, int[] C) {
        int[] pre = A;
        int[] in = B;
        int[] post = C;

        TreeNode root = buildTreeFromInOrderPostOrder(in, post);
        checkTraversal(root,pre);
        return result;

    }

    public void checkTraversal(TreeNode root, int[] pre){
        if(root == null){
            return;
        }

        if(root.data != pre[preIndex++]){
            result = 0;
        }
        checkTraversal(root.left, pre);
        checkTraversal(root.right, pre);
    }


    public TreeNode buildTreeFromInOrderPostOrder(int[] in, int[] post){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i], i);
        }

        postIndex = in.length-1;

        return buildTreeFromInOrderPostOrderHelper(in,post,0,in.length-1,map);
    }

    public TreeNode buildTreeFromInOrderPostOrderHelper(int[] in, int[] post, int st, int end, HashMap<Integer,Integer> map){
        if(st > end)
            return null;

        TreeNode curr = new TreeNode(post[postIndex--]);

        if(st == end)
            return curr;

        int i = map.get(curr.data);

        curr.right = buildTreeFromInOrderPostOrderHelper(in,post,i+1,end,map);
        curr.left = buildTreeFromInOrderPostOrderHelper(in,post,st,i-1,map);

        return curr;
    }

    public static void main(String[] args) {
        int[] A = {13, 12, 61, 44, 23, 33, 82, 99, 71, 58, 88, 50 };
        int[] B = {33, 23, 44, 61, 71, 88, 50, 99, 13, 12, 82, 58};
        int[] C = {61, 44, 23, 12, 33, 71, 50, 99, 13, 82, 88, 58};

        CheckTreeTraversals c = new CheckTreeTraversals();
        c.solve(A,B,C);

    }
}
