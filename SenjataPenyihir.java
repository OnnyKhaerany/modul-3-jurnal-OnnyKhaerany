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

public class SenjataPenyihir{
    public static void main(String[] args) {
        LinkedList senjataList = new LinkedList();
        senjataList.tambahSenjata("Enchanted Talisman", 1870);
        senjataList.tambahSenjata("Winter Truncheon", 1910);
        senjataList.tambahSenjata("Feather of Heaven", 2030);
        senjataList.tambahSenjata("Divine Glaive", 1970);
        senjataList.tambahSenjata("Genius Wand", 2000);
        senjataList.tambahSenjata("Necklake of Durance", 2110);
        senjataList.tambahSenjata("Holy Crystal", 2180);
        senjataList.tambahSenjata("Concentrated Energy", 2020);
        senjataList.tambahSenjata("Ice Queen Wand", 2240);
        senjataList.tambahSenjata("Glowing Wand", 2120);
        senjataList.tambahSenjata("Calamity Reaper", 1950);
        senjataList.tambahSenjata("Clock of Destiny", 1950);
        senjataList.tambahSenjata("Blood Wings", 3000);
        senjataList.tambahSenjata("Fleeting Time", 2050);
        senjataList.tambahSenjata("Lightning Truncheon", 2250);

        System.out.println("Senjata untuk penyihir sebelum diurutkan:");
        senjataList.tampilkanSenjata();
        
        senjataList.sort();

        System.out.println("\nSenjata untuk penyihir setelah diurutkan berdasarkan harga:");
        senjataList.tampilkanSenjata();
    }
}
