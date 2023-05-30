package trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertInTrie("API");
        trie.insertInTrie("APIN");
        trie.insertInTrie("APIS");
        trie.insertInTrie("APPLE");
        System.out.println("Search RAVI in Trie : " + trie.searchInTrie("RAVI"));
        System.out.println("Search RADHA in Trie : " + trie.searchInTrie("RADHA"));
        System.out.println("Search RAD in Trie : " + trie.searchInTrie("RAD"));
        trie.delete("API");
        System.out.println("Search APIS in Trie : " + trie.searchInTrie("APIS"));
    
    }
}
