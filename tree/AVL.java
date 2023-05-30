package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BSTNode root;

    AVL() {
        this.root = null;
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

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("No nodes in Tree.");
            return;
        }
        Queue<BSTNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            BSTNode temp = que.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                que.add(temp.left);
            if (temp.right != null)
                que.add(temp.right);
        }
        System.out.println();
    }

    public Boolean searchNode(BSTNode root, int nodeValue){
        if(root == null) return false;
        if (root.data < nodeValue) searchNode(root.right, nodeValue);
        else if(root.data > nodeValue) searchNode(root.left, nodeValue);
        return true;
    }

    /** rotate node to right */
    public BSTNode rotateRight(BSTNode disabledNode){
        BSTNode temp = disabledNode.left;
        disabledNode.left = disabledNode.left.right;
        temp.right = disabledNode;
        
        // correct the height of disabled node and temp node.
        disabledNode.height = Math.max(getHeight(disabledNode.left), getHeight(disabledNode.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;

        return temp;
    }

    /** rotate node to left */
    public BSTNode rotateLeft(BSTNode disabledNode){
        BSTNode temp = disabledNode.right;
        disabledNode.right = disabledNode.right.left;
        temp.left = disabledNode;

        // correct the height of disabled node and temp node.
        disabledNode.height = Math.max(getHeight(disabledNode.left), getHeight(disabledNode.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;


        return temp;
    }

    public int balanceFactor(BSTNode root){
        if(root == null) return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    /**
     * get height of node
     * @param root
     * @return
     */
    public int getHeight(BSTNode root){
        return root == null ? 0 : root.height;
    }

    public void insertNodeInAVL(int nodeValue){
        root = insertNodeRecursive(root, nodeValue);
        System.out.println("Added Successfully : " + nodeValue);
    }

    public BSTNode insertNodeRecursive(BSTNode root, int nodeValue){
        if(root == null){
            BSTNode newNode = new BSTNode();
            newNode.data = nodeValue;
            newNode.height = 1;
            return newNode;
        }

        if(root.data > nodeValue){
            root.left = insertNodeRecursive(root.left, nodeValue);
        } else {
            root.right = insertNodeRecursive(root.right, nodeValue);
        }
        
        // height update
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        
        // balance factor
        int balanceFactor = balanceFactor(root);
        
        if (balanceFactor > 1 && root.left.data > nodeValue){ // ll rotation
            root = rotateRight(root);
        } else if (balanceFactor > 1 && root.left.data <= nodeValue){ // lr rotation
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balanceFactor < -1 && root.right.data > nodeValue) { // rl rotation
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        } else if (balanceFactor < -1 && root.right.data <= nodeValue) { //rr rotation
            root = rotateLeft(root);
        }

        return root;
    }

    /**
     * find the minimum node in AVL Tree.
     * @param root
     * @return
     */
    public BSTNode minimumNode(BSTNode root){
        if(root.left == null) return root;
        return minimumNode(root.left);
    }

    public BSTNode deleteNode(BSTNode root, int nodeValue){
        if(root == null){
            System.out.println("Node value not found.");
            return null;
        }

        if(root.data > nodeValue){
            root.left = deleteNode(root.left, nodeValue);
        } else if (root.data < nodeValue){
            root.right = deleteNode(root.right, nodeValue);
        } else {
            if(root.left != null && root.right != null){
                BSTNode minNode = minimumNode(root.right);
                root.data = minNode.data;
                root.right = deleteNode(root.right, minNode.data);
            } else if (root.right != null){
                root = root.right;
            } else if (root.left != null){
                root = root.left;
            } else {
                return null;
            }
        }

        System.out.println(" data : " + root.data);
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // balance Factor
        int balanceFactor = balanceFactor(root);
        
        if(balanceFactor > 1 && root.left.left != null){  // ll rotation
            root = rotateRight(root);
        } else if (balanceFactor > 1 && root.left.left == null){ // lr rotation
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balanceFactor < -1 && root.right.right != null){ // rr rotation
            root = rotateLeft(root);
        } else if (balanceFactor < -1 && root.right.right == null) { // rl rotation
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }
        
        return root;
    }
}
