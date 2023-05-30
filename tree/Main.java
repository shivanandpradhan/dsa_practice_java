package tree;

public class Main {
    
    public static void main(String[] args) {
        // TreeNode principalNode = new TreeNode("Principal");
        // TreeNode teacherNode = new TreeNode("teacher");
        // TreeNode staffNode = new TreeNode("staff");
        // TreeNode studentNode = new TreeNode("student");
        // TreeNode guardNode = new TreeNode("guard");

        // principalNode.addChild(teacherNode);
        // principalNode.addChild(staffNode);

        // teacherNode.addChild(studentNode);
        // staffNode.addChild(guardNode);

        // System.out.println(principalNode.print(0));

        // BinaryTreeLL bTree = new BinaryTreeLL();
        // bTree.insertNodeInBinaryTree("n1");
        // bTree.insertNodeInBinaryTree("n2");
        // bTree.insertNodeInBinaryTree("n3");
        // bTree.insertNodeInBinaryTree("n4");
        // bTree.insertNodeInBinaryTree("n5");

        // System.out.println("Preorder Traversal : ");
        // bTree.preOrderTraversal(bTree.root);
        // System.out.println("\nInorder Traversal : ");
        // bTree.inOrderTraversal(bTree.root);
        // System.out.println("\nPost Order Traversal : ");
        // bTree.postOrderTraversal(bTree.root);
        
        // System.out.println("\nRemove n3 from Binary Tree");
        // bTree.deleteNode("n3");

        // System.out.println("Delete n4 from B Tree.");
        // bTree.deleteNode("n4");

        // System.out.println("\nLevel Order Traversal : ");
        // bTree.levelOrderTraversal(bTree.root);

        // System.out.println("Deepest Node : " + bTree.getDeepestNode().data);

        // BST bst = new BST();
        // bst.insertRecursive(10);
        // bst.insertRecursive(20);
        // bst.insertRecursive(15);
        // bst.insertRecursive(5);
        // bst.insertInBST(3);
        // bst.insertInBST(6);
        // bst.inOrderTraversal(bst.root);

        // bst.deleteNodeInBST(bst.root, 10);
        // System.out.println("\nSearch 5 : " + bst.search(5));
        // bst.inOrderTraversal(bst.root);

        AVL avl = new AVL();
        // 30,25,35,20,15,5,10,50,60,70,65
        avl.insertNodeInAVL(30);        
        avl.insertNodeInAVL(25);       
        avl.insertNodeInAVL(35);        
        avl.insertNodeInAVL(20);        
        avl.insertNodeInAVL(15);        
        avl.insertNodeInAVL(5);        
        avl.insertNodeInAVL(10);
        avl.insertNodeInAVL(50);
        avl.insertNodeInAVL(60);
        avl.insertNodeInAVL(70);
        avl.insertNodeInAVL(65);
        
        // avl.inOrderTraversal(avl.root);
        // System.out.println();
        System.out.println("Level Order Traversal : ");
        avl.levelOrderTraversal();
        
        avl.deleteNode(avl.root, 20);
        avl.deleteNode(avl.root, 30);
        avl.deleteNode(avl.root, 35);
        avl.deleteNode(avl.root, 70);
        avl.levelOrderTraversal();
    }
}
