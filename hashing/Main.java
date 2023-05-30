package hashing;

public class Main {
    public static void main(String[] args) {
        
        // DirectChaining dc = new DirectChaining(10);
        // dc.insertInHashTable("Ram");
        // dc.insertInHashTable("Shayam");
        // dc.insertInHashTable("Rahul");
        // dc.insertInHashTable("Pinku");
        // dc.insertInHashTable("Rohit");
        // dc.insertInHashTable("Raghu");
        // dc.printHashTable();
        // System.out.println("Search Pinku : " + dc.search("Pinku"));
        // dc.deleteWord("Pinku");
        // System.out.println("Search Pinku : " + dc.search("Pinku"));

        LinearProbing dc = new LinearProbing(4);
        dc.insertInHashTable("Ram");
        dc.insertInHashTable("Shayam");
        dc.insertInHashTable("Rahul");
        dc.insertInHashTable("Pinku");
        dc.insertInHashTable("Rohit");
        dc.insertInHashTable("Raghu");
        dc.printHashTable();
        System.out.println("Search Rohit : " + dc.searchInHashTable("Rohit"));
        dc.deleteWord("Rohit");
        System.out.println("Search Rohit : " + dc.searchInHashTable("Rohit"));
    }
}
