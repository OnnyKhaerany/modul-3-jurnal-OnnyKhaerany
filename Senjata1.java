//class ini merepresentasikan node dalam double linked list
class Node {
    //Bagian ini merupakan deklarasi atribut senjata 
    String senjata;
    //Bagian ini merupakan deklarasi atribut harga yang akan merepresentasikan harga dari senjata
    int harga;
    //Bagian ini merupakan deklarasi atribut stok yang akan merepresentasikan stok dari senjata
    int stok;
    //Bagian ini merupakan referensi ke node berikutnya pada double linked list
    Node next;
    //Bagian ini merupakan referensi ke node sebelumnya pada double linked list
    Node prev;

    //Bagian ini adalah deklarasi konstruktor untuk kelas Node. Konstruktor digunakan untuk membuat objek dari kelas ini dan dijalankan saat objek dibuat.
    public Node(String senjata, int stok) {
        //Bagian ini merujuk pada atribut senjata dari objek yang sedang dibuat
        this.senjata = senjata;
        //Bagian ini merujuk pada atribut stok dari objek yang sedang dibuat
        this.stok = stok;
        //Bagian ini adalah bagian dari inisialisasi objek dan dapat bervariasi tergantung pada kebutuhan.
        this.next = null;
        //Bagian ini juga merupakan bagian dari inisialisasi objek dan dapat bervariasi tergantung pada kebutuhan.
        this.prev = null;
    }
}

//Bagian ini merupakan deklarasi kelas LinkedList yang akan digunakan untuk menyimpan dan mengelola senjata dalam bentuk linked list.
class LinkedList {
    //Bagian ini merupakan deklarasi atribut head yang merupakan referensi ke node pertama dalam linked list. 
    Node head;
    //Bagian ini merupakan deklarasi atribut sortedHead yang merupakan referensi ke node pertama setelah pengurutan menggunakan bubble sort.
    Node sortedHead;

    //Bagian ini merupakan deklarasi metode tambahSenjata untuk menambahkan senjata baru ke dalam linked list. 
    public void tambahSenjata(String senjata, int stok) {
        //Bagian ini membuat node baru (newNode) dengan menggunakan konstruktor Node dan menginisialisasi atribut senjata dan stok sesuai dengan parameter yang diterima.
        Node newNode = new Node(senjata, stok);

        //Bagian ini merupakan inisialisasi variabel current dengan referensi ke node pertama (head) untuk digunakan dalam penambahan senjata.
        Node current = head;

        //Bagian ini memeriksa apakah linked list masih kosong atau stok senjata baru lebih kecil atau sama dengan stok senjata yang ada di node pertama.
        if (current == null || current.stok >= stok) {
            //Bagian ini menyambungkan newNode ke node pertama saat ini
            newNode.next = current;
            //Bagian ini mengatur prev dari newNode menjadi null karena newNode akan menjadi node pertama
            newNode.prev = null;

            //Bagian ini memeriksa jika linked list tidak kosong 
            if (current != null) {
                //Jika linked list tidak kosong maka atur prev dari node pertama (current) menjadi newNode.
                current.prev = newNode;
            }

            //Bagian ini mengatur head menjadi newNode karena newNode sekarang menjadi node pertama.
            head = newNode;

        //Jika linked list tidak kosong dan stok senjata baru lebih besar dari stok senjata node pertama, lanjutkan ke bagian ini.
        } else {
            //Bagian ini melakukan iterasi melalui linked list untuk menemukan posisi yang tepat sesuai dengan urutan jumlah stok.
            while (current.next != null && current.next.stok < stok) {
                current = current.next;
            }

            //Bagian ini menyambungkan newNode ke node berikutnya dari current.
            newNode.next = current.next;

            //Bagian ini memeriksa jika node berikutnya dari current tidak null
            if (current.next != null) {
                //Bagian ini mengatur prev dari node tersebut menjadi newNode.
                current.next.prev = newNode;
            }

            //Bagian ini menyambungkan newNode ke current.next.
            current.next = newNode;
            //Bagian ini mengatur prev dari newNode menjadi current.
            newNode.prev = current;
        }
    }

    //Bagian ini merupakan deklarasi metode tampilkanSenjata yang bertujuan untuk menampilkan informasi tentang senjata dari setiap node dalam linked list.
    public void tampilkanSenjata() {
        //Bagian ini merupakan inisialisasi variabel current dengan referensi ke node pertama (head). Ini digunakan untuk iterasi melalui linked list.
        Node current = head;
        //Bagian ini memulai loop while yang akan terus berjalan selama current tidak null. Loop ini digunakan untuk menelusuri seluruh linked list.
        while (current != null) {
            //Bagian ini mnampilkan informasi tentang node saat ini, yang dalam hal ini adalah referensi objek Node (alamat memori). Ini memberikan output yang unik untuk setiap node.
            System.out.println("Id = " + current);
            //Bagian ini menampilkan nama senjata dari node saat ini.
            System.out.println("Nama = " + current.senjata);
            //Bagian ini menampilkan jumlah stok senjata dari node saat ini.
            System.out.println("Stok = " + current.stok);
            //Bagian ini menampilkan baris kosong untuk memberikan pemisah antara informasi tentang senjata dari dua node berbeda.
            System.out.println();
            //Bagian ini menggeser current ke node berikutnya dalam linked list. Ini dilakukan agar loop dapat melanjutkan ke node berikutnya.
            current = current.next;
        }
    }

    //Bagian ini merupakan deklarasi metode bubbleSort yang bertujuan untuk mengurutkan linked list menggunakan algoritma bubble sort.
    public void bubbleSort() {
    //Bagian ini merupakan deklarasi variabel current yang akan digunakan untuk iterasi melalui linked list selama proses pengurutan.
    Node current;
    //Bagian ini merupakan deklarasi variabel boolean swapped yang akan menunjukkan apakah terjadi pertukaran posisi node selama iterasi saat ini.
    boolean swapped;

    //Bagian ini memulai blok do-while loop. Pengurutan menggunakan bubble sort akan dilakukan setidaknya satu kali, dan loop akan terus berjalan sampai tidak ada lagi pertukaran yang dilakukan.
    do {
        //Bagian ini menyetel swapped menjadi false pada awal setiap iterasi loop. Ini akan diperbarui menjadi true jika terjadi pertukaran posisi node.
        swapped = false;
        //Bagian ini menginisialisasi variabel current dengan node pertama (head). Ini akan digunakan untuk iterasi melalui linked list selama satu iterasi loop.
        current = head;

        //Bagian ini  memulai loop while untuk melakukan satu iterasi melalui linked list dan memeriksa apakah pertukaran perlu dilakukan.
        while (current != null && current.next != null) {
            //Bagian ini memeriksa apakah jumlah stok dari node saat ini lebih besar dari jumlah stok dari node berikutnya.
            if (current.stok > current.next.stok) {
                //Bagian ini menangani pertukaran node pertama. Jika node saat ini bukan node pertama, mengubah next dari node sebelumnya untuk menunjuk ke node berikutnya. Jika node saat ini adalah node pertama, mengubah head menjadi node berikutnya.
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                //Bagian ini menyesuaikan prev dari node berikutnya untuk menunjuk ke node sebelumnya setelah pertukaran.
                current.next.prev = current.prev;
                //Bagian ini menyesuaikan prev dari node saat ini untuk menunjuk ke node berikutnya setelah pertukaran.
                current.prev = current.next;
                //Bagi ini  menyesuaikan next dari node saat ini untuk melompat ke node berikutnya setelah pertukaran.
                current.next = current.next.next;

                //jika node berikutnya tidak null
                if (current.next != null) {
                    //Maka menyesuaikan prev dari node berikutnya untuk menunjuk ke node saat ini setelah pertukaran
                    current.next.prev = current;
                }

                //Bagian ini menyesuaikan next dari node sebelumnya untuk menunjuk ke node saat ini setelah pertukaran.
                current.prev.next = current;
                //Bagian ini mengatur swapped menjadi true karena pertukaran posisi node telah terjadi.
                swapped = true;
            //Jika kondisi tidak terpenuhi, lanjut ke bagian ini.
            } else {
                //Pindah ke node berikutnya dalam linked list.
                current = current.next;
            }
        }
        //Bagian ini menandakan akhir dari do-while loop. Loop ini akan terus berjalan sampai tidak ada lagi pertukaran yang dilakukan.
    } while (swapped);
    }
}

//Deklarasi kelas Senjata1.
public class Senjata1 {
    //Deklarasi metode main, yang merupakan metode utama yang akan dijalankan saat program dimulai.
    public static void main(String[] args) {
        //Membuat objek senjataPetarung dari kelas LinkedList. Objek ini akan digunakan untuk menyimpan dan mengelola senjata dalam bentuk linked list.
        LinkedList senjataPetarung = new LinkedList();
        senjataPetarung.tambahSenjata("Wind of Nature", 25);
        senjataPetarung.tambahSenjata("Golden Staff", 27);
        senjataPetarung.tambahSenjata("Rose Gold Meteor", 17);
        senjataPetarung.tambahSenjata("Bloodlust Axe", 9);
        senjataPetarung.tambahSenjata("Hunter Strike", 15);
        senjataPetarung.tambahSenjata("Blade of Despair", 23);
        senjataPetarung.tambahSenjata("Scarlet Phantom", 16);
        senjataPetarung.tambahSenjata("Windtalker", 12);
        senjataPetarung.tambahSenjata("Endless Battle", 4);
        senjataPetarung.tambahSenjata("Berserker's Fury", 3);
        senjataPetarung.tambahSenjata("Haas's Claws", 19);
        senjataPetarung.tambahSenjata("Malefic Roar", 3);
        senjataPetarung.tambahSenjata("Sea Halberd", 6);
        senjataPetarung.tambahSenjata("Demon Hunter Sword", 8);

        //Menampilkan pesan yang memberitahu bahwa senjata akan ditampilkan setelah diurutkan menggunakan bubble sort.
        System.out.println("\nSenjata setelah diurutkan menggunakan Bubble Sort: ");
        //Memanggil metode bubbleSort untuk mengurutkan senjata dalam linked list menggunakan algoritma bubble sort.
        senjataPetarung.bubbleSort();
        //Memanggil metode tampilkanSenjata untuk menampilkan senjata setelah diurutkan.
        senjataPetarung.tampilkanSenjata();
    }
}