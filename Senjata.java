//Program Mengurutkan Senjata Berdasarkan Harga

class Node {
    String senjata;
    int harga;
    Node next;
    Node prev;

    public Node(String senjata, int harga) {
        this.senjata = senjata;
        this.harga = harga;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    Node head;
    Node sortedHead; 

    public void tambahSenjata(String senjata, int harga) {
        Node newNode = new Node(senjata, harga);
        newNode.next = head;
        if (head != null) {
           head.prev = newNode; 
        }
        head = newNode;
    }

    public void tampilkanSenjata() {
        Node current = head;
        while (current != null) {
            System.out.println(current.senjata + ": $" + current.harga);
            current = current.next;
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }

        head = sortedHead;
    }

    private void sortedInsert(Node newNode) {
        if (sortedHead == null || sortedHead.harga >= newNode.harga) {
            newNode.next = sortedHead;
            newNode.prev = sortedHead;
            if (sortedHead != null){
                sortedHead.prev = newNode;
            } 
            sortedHead = newNode;
        } else {
            Node current = sortedHead;
            while (current.next != null && current.next.harga < newNode.harga) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }
}

public class Senjata{
    public static void main(String[] args) {
        LinkedList senjataPenyihir = new LinkedList();
        senjataPenyihir.tambahSenjata("Enchanted Talisman", 1870);
        senjataPenyihir.tambahSenjata("Winter Truncheon", 1910);
        senjataPenyihir.tambahSenjata("Feather of Heaven", 2030);
        senjataPenyihir.tambahSenjata("Divine Glaive", 1970);
        senjataPenyihir.tambahSenjata("Genius Wand", 2000);
        senjataPenyihir.tambahSenjata("Necklake of Durance", 2110);
        senjataPenyihir.tambahSenjata("Holy Crystal", 2180);
        senjataPenyihir.tambahSenjata("Concentrated Energy", 2020);
        senjataPenyihir.tambahSenjata("Ice Queen Wand", 2240);
        senjataPenyihir.tambahSenjata("Glowing Wand", 2120);
        senjataPenyihir.tambahSenjata("Calamity Reaper", 1950);
        senjataPenyihir.tambahSenjata("Clock of Destiny", 1950);
        senjataPenyihir.tambahSenjata("Blood Wings", 3000);
        senjataPenyihir.tambahSenjata("Fleeting Time", 2050);
        senjataPenyihir.tambahSenjata("Lightning Truncheon", 2250);
        
        senjataPenyihir.sort();
        System.out.println("\nSenjata untuk penyihir setelah diurutkan berdasarkan harga:");
        senjataPenyihir.tampilkanSenjata();

        LinkedList senjataPetarung = new LinkedList();
        senjataPetarung.tambahSenjata("Demon Hunter Sword", 2180);
        senjataPetarung.tambahSenjata("Sea Halberd", 2200);
        senjataPetarung.tambahSenjata("Corrosion Scythe", 2050);
        senjataPetarung.tambahSenjata("Malefic Roar", 2060);
        senjataPetarung.tambahSenjata("Haas's Claws", 1810);
        senjataPetarung.tambahSenjata("Berserker's Fury", 2350);
        senjataPetarung.tambahSenjata("Endless Battle", 2470);
        senjataPetarung.tambahSenjata("Hunter Strike", 2010);
        senjataPetarung.tambahSenjata("Scarlet Phantom", 2020);
        senjataPetarung.tambahSenjata("Blade of the Heptaseas", 1950);
        senjataPetarung.tambahSenjata("Windtalker", 1870);
        senjataPetarung.tambahSenjata("Blade of Despair", 3010);
        senjataPetarung.tambahSenjata("Bloodlust Axe", 1970);
        senjataPetarung.tambahSenjata("Golden Staff", 2100);
        senjataPetarung.tambahSenjata("Wind of Nature", 1910);
        senjataPetarung.tambahSenjata("Rose Gold Meteor", 2270);

        senjataPetarung.sort();
        System.out.println("\nSenjata untuk petarung setelah diurutkan berdasarkan harga:");
        senjataPetarung.tampilkanSenjata();
    }
}