package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    public BinaryTreeNode root;

    public BinaryTreeLL(){
        this.root = null;
    }

    public void preOrderTraversal(BinaryTreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(BinaryTreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BinaryTreeNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrderTraversal(BinaryTreeNode root) {
        if(root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right); 
        }
        System.out.println();
    }

    public void insertNodeInBinaryTree(String value){
        // create a node
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = value;

        if(this.root == null){
            this.root = node;
            return;
        } 

        Queue<BinaryTreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            BinaryTreeNode tempNode = que.remove();
            if(tempNode.left == null){
                tempNode.left = node;
                break;
            } else if(tempNode.right == null){
                tempNode.right = node;
                break;
            } else{
                que.add(tempNode.left);
                que.add(tempNode.right);
            }
        }
    }

    public BinaryTreeNode getDeepestNode(){
        Queue<BinaryTreeNode> que = new LinkedList<>();
        que.add(root);
        BinaryTreeNode presentNode = null;
        while(!que.isEmpty()){
            presentNode = que.remove();
            if(presentNode.left != null) que.add(presentNode.left);
            if(presentNode.right != null) que.add(presentNode.right);
        }
        return presentNode;
    }

    public void deleteDeepestNode(){
        Queue<BinaryTreeNode> que = new LinkedList<>();
        que.add(root);
        BinaryTreeNode previousNode = null; 
        BinaryTreeNode currentNode = null;
        while(!que.isEmpty()){
            previousNode = currentNode;
            currentNode = que.remove();
            if(currentNode.left == null){
                previousNode.right = null;
                return;
            } else if (currentNode.right == null){
                currentNode.left = null;
                return;
            } else {
                que.add(currentNode.left);
                que.add(currentNode.right);
            }
        }
    }

    // delete node from the Binary Tree.
    public void deleteNode(String value){
        Queue<BinaryTreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            BinaryTreeNode node = que.remove();
            if(node.data == value){
                BinaryTreeNode deepNode = getDeepestNode();
                if(deepNode == node){
                    deleteDeepestNode();
                } else {
                    node.data = deepNode.data;
                    deleteDeepestNode();
                }
                return;
            }
            if(node.left != null) que.add(node.left);
            if(node.right != null) que.add(node.right);
        }
    }

    public void deleteBinaryTree(){
        this.root = null;
    }
}
