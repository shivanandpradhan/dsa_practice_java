package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public BSTNode root;

    public BST() {
        root = null;
    }

    public void insertInBST(int value) {
        BSTNode node = new BSTNode();
        node.data = value;
        if (root == null) {
            root = node;
            return;
        }

        BSTNode temp = root;
        while (true) {
            if (temp.data >= value) {
                if (temp.left == null) {
                    temp.left = node;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void insertRecursive(int value) {
        root = insertNodeInBSTRecursive(root, value);
    }

    private BSTNode insertNodeInBSTRecursive(BSTNode currentNode, int value) {
        if (currentNode == null) {
            BSTNode node = new BSTNode();
            node.data = value;
            return node;
        } else if (currentNode.data >= value) {
            currentNode.left = insertNodeInBSTRecursive(currentNode.left, value);
        } else {
            currentNode.right = insertNodeInBSTRecursive(currentNode.right, value);
        }
        return currentNode;
    }

    public void preOrderTraversal(BSTNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(BSTNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BSTNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrderTraversal(BSTNode root) {
        if (root == null)
            return;
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public Boolean search(int value) {
        BSTNode temp = root;
        while (temp != null) {
            if (temp.data == value)
                return true;
            if (temp.data <= value)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return false;
    }

    /** finding the maximum node in BST */
    public BSTNode maximumNode(BSTNode root) {
        if (root.right == null)
            return root;
        return maximumNode(root.right);
    }

    /** Delete Node in BST */
    public BSTNode deleteNodeInBST(BSTNode root, int value) {
        if (root == null) {
            System.out.println("Node not found to Delete : " + value);
            return null;
        }
        if (root.data > value) {
            root.left = deleteNodeInBST(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNodeInBST(root.right, value);
        } else {
            if(root.left != null & root.right != null){
                BSTNode maxNode = maximumNode(root.left);
                root.data = maxNode.data;
                root.left = deleteNodeInBST(root.left, maxNode.data);
            } else if(root.right != null){
                root = root.right;
            } else if (root.left != null){
                root = root.left;
            } else {
                root = null;
            }
        }
        return root;
    }

    public void deleteBST() {
        this.root = null;
        System.out.println("BST tree deleted Successfully.");
    }
}
