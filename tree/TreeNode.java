package tree;

import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    TreeNode(String data){
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChild(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        String ret = "  ".repeat(level) + data + "\n";
        for(TreeNode node : this.children){
            ret += node.print(level + 1);
        }
        return ret;
    }
}
