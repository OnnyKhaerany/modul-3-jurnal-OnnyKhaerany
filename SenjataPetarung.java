class Node {
    String senjata;
    int harga;
    Node next;

    public Node(String senjata, int harga) {
        this.senjata = senjata;
        this.harga = harga;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node sorted; // Menambahkan variabel sorted di sini

    public void tambahSenjata(String senjata, int harga) {
        Node newNode = new Node(senjata, harga);
        newNode.next = head;
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
            return; // Tidak perlu mengurutkan jika kurang dari dua elemen
        }

        Node current = head;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }

        // Mengganti head dengan linked list yang sudah diurutkan
        head = sorted;
    }

    private void sortedInsert(Node newNode) {
        if (sorted == null || sorted.harga >= newNode.harga) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.harga < newNode.harga) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}

public class SenjataPetarung {
    public static void main(String[] args) {
        LinkedList senjataList = new LinkedList();
        senjataList.tambahSenjata("Demon Hunter Sword", 2180);
        senjataList.tambahSenjata("Sea Halberd", 2200);
        senjataList.tambahSenjata("Corrosion Scythe", 2050);
        senjataList.tambahSenjata("Malefic Roar", 2060);
        senjataList.tambahSenjata("Haas's Claws", 1810);
        senjataList.tambahSenjata("Berserker's Fury", 2350);
        senjataList.tambahSenjata("Endless Battle", 2470);
        senjataList.tambahSenjata("Hunter Strike", 2010);
        senjataList.tambahSenjata("Scarlet Phantom", 2020);
        senjataList.tambahSenjata("Blade of the Heptaseas", 1950);
        senjataList.tambahSenjata("Windtaker", 1870);
        senjataList.tambahSenjata("Blade of Despair", 3010);
        senjataList.tambahSenjata("Golden Staff", 2100);
        senjataList.tambahSenjata("Wind of Nature", 1910);
        senjataList.tambahSenjata("Rose Gold Meteor", 2270);

        System.out.println("Senjata untuk petarung sebelum diurutkan:");
        senjataList.tampilkanSenjata();
        
        senjataList.sort();

        System.out.println("\nSenjata untuk petarung setelah diurutkan berdasarkan harga:");
        senjataList.tampilkanSenjata();
    }
}