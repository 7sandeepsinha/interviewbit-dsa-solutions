package org.sandeep.Trees;

public class LowestCommonAncestor {
    static boolean flag = false;
    public static  TreeNode findLCAHelper(TreeNode root, int data1, int data2){
        root = findLCA(root, data1,data2);
        if(flag){
            return root;
        }else {
            return new TreeNode(-1);
        }
    }
    public static TreeNode findLCA(TreeNode root, int data1, int data2){
        if(root == null){
            return root;
        }

        if(root.data == data1){
            if(findNode(root,data2)) {
                return root;
            }
        }else if(root.data == data2){
            if(findNode(root,data1)) {
                return root;
            }
        }

        boolean d1 = findNode(root.left, data1);  // true
        boolean d2 = findNode(root.left, data2);  // false

        if(d1 && d2){
            return findLCA(root.left, data1, data2);
        }else if(!d1 && !d2){
            boolean rst1 = findNode(root.right,data1);
            boolean rst2 = findNode(root.right, data2);
            if(rst1 && rst2){
                return findLCA(root.right, data1, data2);
            }else{
                return new TreeNode(-1);
            }
        } else if(d1){
            if(findNode(root.right,data2)){
                return root;
            }else{
                return new TreeNode(-1);
            }
        }else if(d2){
            if(findNode(root.right,data1)){
                return root;
            }else{
                return new TreeNode(-1);
            }
        } else{
            return new TreeNode(-1);
        }
    }

    public static boolean findNode(TreeNode root, int data){
        if(root == null){
            return false;
        }else if(root.data == data){
            return true;
        }

        boolean lst = findNode(root.left, data);
        boolean rst = findNode(root.right, data);

        return (lst || rst);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(8);

        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(10);

        System.out.println(findLCA(root,23,8).data);

    }
}
