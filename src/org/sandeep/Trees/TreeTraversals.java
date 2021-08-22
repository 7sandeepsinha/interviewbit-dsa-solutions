package org.sandeep.Trees;

import java.util.*;

public class TreeTraversals {
    public int index = 0;
    public int postIndex = 0;

    public static void preOrderIterative(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;
        nodes.add(root);
        while(curr != null && !nodes.empty()){
            curr = nodes.pop();
            System.out.println(curr.data);
            if(curr.right != null){
                nodes.add(curr.right);
            }
            if(curr.left != null){
               nodes.add(curr.left);
            }
        }
    }

    public static void preOrderRecursive(TreeNode root){
        if(root == null)
            return;

        System.out.println(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void postOrderIterative1(TreeNode root){
        if(root == null)
                return;
        Stack<TreeNode> nodes = new Stack<>();
        HashSet<TreeNode> nodeSet = new HashSet<>();
        nodes.add(root);
        TreeNode prev = root;
        TreeNode curr = root;

        while (curr != null && !nodes.isEmpty()){
            if(curr.left == null && curr.right == null){
                curr = nodes.pop();
                if(!nodes.isEmpty())
                    prev = nodes.peek();
                nodeSet.add(curr);
                System.out.println(curr.data);
                curr = prev;
                continue;
            }

            if(nodeSet.contains(curr.left) || nodeSet.contains(curr.right)){
                curr = nodes.pop();
                if(!nodes.isEmpty())
                    prev = nodes.peek();
                nodeSet.add(curr);
                System.out.println(curr.data);
                curr = prev;
                continue;
            }



            if(curr.right != null){
                nodes.add(curr.right);
                prev = curr.right;
            }
            if(curr.left != null){
                nodes.add(curr.left);
                prev = curr.left;
            }

            curr = prev;
        }
    }

    public static void postOrderIterative(TreeNode A){
        ArrayList<Integer> result= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();

        while(true) {
            while(A != null) {
                stack.push(A);
                stack.push(A);
                A = A.left;
            }
            if(stack.empty()) return;
            A = stack.pop();
            if(!stack.empty() && stack.peek() == A)
                A = A.right;
            else {
                result.add(A.data);
                A = null;
            }
        }
    }

    public static void postOrderRecursive(TreeNode root){
        if(root == null)
                return;

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.data);
    }

    public static void inOrderIterative(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;

        while(true){
            while(curr != null){
                nodes.add(curr);
                curr = curr.left;
            }
            if(nodes.isEmpty())
                return;
            curr = nodes.pop();
            if(curr != null) {
                System.out.println(curr.data);
            }
            curr = curr.right;
        }
    }

    public static void inOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        inOrderRecursive(root.left);
        System.out.println(root.data);
        inOrderRecursive(root.right);
    }

    public static void zigZagTraversal(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> printer ;
        boolean flag = true;
        TreeNode curr = null;
        while(!queue.isEmpty()){
            printer = new ArrayList<>();
            while(queue.peek() == null){
                queue.poll();
                queue.add(null);
                flag = !flag;
            }

            while(!queue.isEmpty() && queue.peek() != null){
                curr = queue.poll();
                printer.add(curr.data);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            if(flag){
                for(int i=0;i<printer.size();i++){
                    System.out.print(printer.get(i) + " ");
                }
            }else {
                for(int i=printer.size()-1;i>=0;i--){
                    System.out.print(printer.get(i) + " ");
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> zigZagTraversal2(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        s1.add(root);

        while(!(s1.isEmpty() && s2.isEmpty())){
            ArrayList<Integer> subList = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                subList.add(curr.data);
                if(curr.left != null){
                    s2.add(curr.left);
                }
                if(curr.right != null){
                    s2.add(curr.right);
                }
            }

            list.add(subList);
            subList = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode curr = s2.pop();
                subList.add(curr.data);
                if(curr.right != null){
                    s1.add(curr.right);
                }
                if(curr.left != null){
                    s1.add(curr.left);
                }
            }
            list.add(subList);
        }

        return list;

    }

    public TreeNode buildTreeFromInOrderPreOrder(int[] in, int[] pre){
        return buildTreeFromInOrderPreOrderHelper(in,pre,0,in.length-1);
    }

    public TreeNode buildTreeFromInOrderPreOrderHelper(int[] in, int[] pre, int st, int end){
        if(st > end)
                return null;

        TreeNode curr = new TreeNode(pre[index++]);

        if(st == end)
                return curr;

        int i = searchArray(curr.data, in);

        curr.left = buildTreeFromInOrderPreOrderHelper(in,pre,st,i-1);
        curr.right = buildTreeFromInOrderPreOrderHelper(in,pre,i+1,end);

        return curr;
    }

    public int searchArray(int x, int[] arr){
        for(int i=0;i<arr.length;i++){
            if(x == arr[i])
                return i;
        }
        return -1;
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



        return curr;
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


       inOrderRecursive(root);


    }
}
