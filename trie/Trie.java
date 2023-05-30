package trie;

public class Trie {

    public TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insertInTrie(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                node = new TrieNode();
                current.getChildren().put(ch, node);
            }
            current = node;
        }
        current.setEndOfString(true);
        System.out.println("Word ADDED in Trie Successfully : " + word);
    }

    public Boolean searchInTrie(String word) {
        TrieNode currTrieNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            TrieNode childNode = currTrieNode.getChildren().get(ch);
            if (childNode == null) {
                return false;
            }
            currTrieNode = childNode;
        }
        return currTrieNode.isEndOfString();
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.getChildren().get(ch);
        boolean canThisNodeBeDeleted;

        // if you are at the last character.
        if (index == word.length() - 1) {
            // if at last node, its children size is 1 or greater
            // means it acts as prefix for other string. Therefore don't delete it
            if (currentNode.getChildren().size() >= 1) {
                currentNode.setEndOfString(false); // set end of string to false.
                return false;
            } else {
                // remove ch from the children
                parentNode.getChildren().remove(ch);
                return true;
            }
        }
        // if current node children has size greater than one
        // means act as prefix for other string, don't delete it.
        if (currentNode.getChildren().size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }

        // if current node is acting as end of string for other string,
        // then don't delete node.
        if (currentNode.isEndOfString() == true) {
            delete(currentNode, word, index + 1);
            return false;
        }

        // other than this, 
        canThisNodeBeDeleted = delete(currentNode, word, index + 1);
        if (canThisNodeBeDeleted == true) { // if node can be deleted, then remove it.
            parentNode.getChildren().remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if (searchInTrie(word) == true) {
            delete(root, word, 0);
        }
    }
}
