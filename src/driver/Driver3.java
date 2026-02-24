import java.util.ArrayList;
import java.util.Scanner;

// CLASS PELANGGAN
class Pelanggan {
    String nama;
    String noHp;

    Pelanggan(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }
}

// CLASS ORDER
class LaundryOrder {
    Pelanggan pelanggan;
    double berat;
    double hargaPerKg;
    String status;

    LaundryOrder(Pelanggan pelanggan, double berat, double hargaPerKg) {
        this.pelanggan = pelanggan;
        this.berat = berat;
        this.hargaPerKg = hargaPerKg;
        this.status = "Diproses";
    }

    double hitungTotal() {
        return berat * hargaPerKg;
    }
}

public class Driver3 {
     static Scanner sc = new Scanner(System.in);
    static ArrayList<LaundryOrder> daftarOrder = new ArrayList<>();

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n=== SISTEM LAUNDRY ===");
            System.out.println("1. Tambah Order");
            System.out.println("2. Lihat Order");
            System.out.println("3. Update Status");
            System.out.println("4. Hapus Order Yang Sudah Diambil");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahOrder();
                    break;
                case 2:
                    lihatOrder();
                    break;
                case 3:
                    updateStatus();
                    break;
                case 4:
                    hapusOrderDiambil();
                    break;
            }

        } while (pilihan != 0);
    }

    //TAMBAH ORDER
    static void tambahOrder() {

        System.out.print("Nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("No HP: ");
        String hp = sc.nextLine();

        System.out.print("Berat laundry (kg): ");
        double berat = sc.nextDouble();

        Pelanggan p = new Pelanggan(nama, hp);
        LaundryOrder order = new LaundryOrder(p, berat, 7000);

        daftarOrder.add(order);

        System.out.println("Order berhasil ditambahkan!");
        System.out.println("Total bayar: " + order.hitungTotal());
    }

    //  LIHAT ORDER 
    static void lihatOrder() {

        if (daftarOrder.isEmpty()) {
            System.out.println("Belum ada order.");
            return;
        }

        for (int i = 0; i < daftarOrder.size(); i++) {
            LaundryOrder o = daftarOrder.get(i);

            System.out.println("\nOrder ke-" + i);
            System.out.println("Nama : " + o.pelanggan.nama);
            System.out.println("HP   : " + o.pelanggan.noHp);
            System.out.println("Berat: " + o.berat + " kg");
            System.out.println("Total: " + o.hitungTotal());
            System.out.println("Status: " + o.status);
        }
    }

    //  UPDATE STATUS 
    static void updateStatus() {

        lihatOrder();

        if (daftarOrder.isEmpty()) return;

        System.out.print("Pilih nomor order: ");
        int index = sc.nextInt();
        sc.nextLine();

        System.out.print("Status baru (Diproses/Selesai/Diambil): ");
        String statusBaru = sc.nextLine();

        daftarOrder.get(index).status = statusBaru;

        System.out.println("Status berhasil diupdate!");
    }

    //  HAPUS ORDER DIAMBIL 
    static void hapusOrderDiambil() {

        if (daftarOrder.isEmpty()) {
            System.out.println("Tidak ada order.");
            return;
        }

        int sebelum = daftarOrder.size();

        daftarOrder.removeIf(order -> order.status.equalsIgnoreCase("Diambil"));

        int sesudah = daftarOrder.size();

        System.out.println((sebelum - sesudah) + " order yang sudah Diambil berhasil dihapus.");
    }
}
