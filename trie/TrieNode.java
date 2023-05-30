package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode{

    private Map<Character, TrieNode> children; 
    private boolean endOfString;

    public TrieNode(){
        children = new HashMap<>();
        endOfString = false;
    }
    
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isEndOfString() {
        return endOfString;
    }

    public void setEndOfString(boolean endOfString) {
        this.endOfString = endOfString;
    }

}