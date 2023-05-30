package hashing;

import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;

    // constructor
    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = null;
        }
    }

    // hash function
    public int modASCIIHashFunction(String word, int M) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum % M;
    }

    // insert method
    public void insertInHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[index] == null) {
            // insert new linked list item
            LinkedList<String> ll = new LinkedList<>();
            ll.add(word);
            hashTable[index] = ll;
        } else {
            hashTable[index].add(word);
        }
    }

    /**
     * print hash table
     */
    public void printHashTable() {
        if (hashTable == null) {
            System.out.println("No HashTable Exists.");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index : " + i + ", Key : " + hashTable[i]);
            }
        }
    }

    /**
     * search for the word in the hash Table.
     * @param word
     * @return
     */
    public Boolean search(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        for(String str : hashTable[index]){
            if (str.equals(word)){
                return true;
            }
        }
        return false;
    }

    /** 
     * delete word from the hash table
     */
    public Boolean deleteWord(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = 0; i < hashTable[index].size(); i++){
            if(hashTable[index].get(i).equals(word)){
                hashTable[index].remove(i);
                System.out.println("Removed word : " + word);
                return true;
            }
        }
        return false;
    }
}
