package hashing;

import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int usedNumberOfCells;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedNumberOfCells = 0;
    }

    // hash function
    public int modASCIIHashFunction(String word, int M) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum % M;
    }

    /**
     * load factor ( best practise )
     * if load factor > 0.75, then rehash keys
     * 
     * @return
     */
    public double getLoadFactor() {
        return usedNumberOfCells * 1.0 / hashTable.length;
    }

    public void reHashKeys(String word) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < hashTable.length; i++) {
            list.add(hashTable[i]);
        }
        list.add(word);
        // create new hash table with size 2 times hash table
        hashTable = new String[hashTable.length * 2];
        usedNumberOfCells = 0;

        for (String str : list) {
            insertInHashTable(str);
        }
    }

    /**
     * insert word in the hash table.
     * 
     * @param word
     */
    public void insertInHashTable(String word) {
        if (getLoadFactor() > 0.75) {
            reHashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            if (hashTable[index] != null) {
                int pos = (index + 1) % hashTable.length;
                while (pos != index) {
                    if (hashTable[pos] == null) {
                        hashTable[pos] = word;
                        break;
                    }
                    pos = (pos + 1) % hashTable.length;
                }
            } else {
                hashTable[index] = word;
            }
            usedNumberOfCells++;
        }
    }

    /**
     * print hash table
     */
    public void printHashTable() {
        if (hashTable == null) {
            System.out.println("No Hash Table Found");
            return;
        }
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("index : " + i + ", key : " + hashTable[i]);
        }
    }

    /**
     * search in the hash Table
     * 
     * @param word
     */
    public Boolean searchInHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[index] == word)
            return true;
        int pos = (index + 1) % hashTable.length;
        while (pos != index) {
            if (hashTable[pos] == word)
                return true;
            pos = (pos + 1) % hashTable.length;
        }
        return false;
    }

    public Boolean deleteWord(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = 0; i < hashTable.length; i++){
            int pos = (index + i) % hashTable.length;
            if (hashTable[pos] == word) {
                hashTable[index] = null;
                return true;
            }
        };
        return false;
    }
}
