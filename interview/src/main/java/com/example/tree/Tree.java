package com.example.tree;

/**
 * Created by binea on 2016/11/10.
 */

public class Tree {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isBalanceTree(Node root) {
        if (checkHeight(root) == -1) {
            return false;
        }
        return true;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private int lastValue = Integer.MIN_VALUE;

    public boolean isBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (!isBalanceTree(node.left)) {
            return false;
        }

        if (node.val < lastValue) return false;
        lastValue = node.val;

        if (!isBalanceTree(node.right)) {
            return false;
        }

        return true;
    }

    public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val > max || root.val < min) {
            return false;
        }

        if (!checkBST(root.left, min, root.val) || !checkBST(root.right, root.val, max)) {
            return false;
        }

        return true;

    }

    public Node inorderSucc(Node n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n);
        } else {
            Node q = n;
            Node x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public Node leftMostChild(Node n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.left, p) || covers(root.right, p);
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return commonAncestorHelper(root, p, q);
    }

    public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == q || root == p) return root;

        boolean isPonLeft = covers(root.left, p);
        boolean isQonLeft = covers(root.left, q);
        if (isPonLeft != isQonLeft) return root;

        TreeNode childSide = isPonLeft ? root.left : root.right;
        return commonAncestorHelper(childSide, p, q);
    }

    public boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    public boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            if (matchTree(t1, t2)) return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;

        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;

        return (matchTree(t1.left, t1.right) && matchTree(t1.right, t2.right));
    }

    public void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        path[level] = node.val;

        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        path[level] = Integer.MIN_VALUE;
    }

    public void findSum(TreeNode root, int sum) {
        int depth = depath(root);
        int[] path = new int[depth];
        findSum(root, sum, path, 0);
    }

    public int depath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depath(node.left), depath(node.right)) + 1;
    }

    public void print(int[] path, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}
