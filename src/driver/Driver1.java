import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MenuItem {
    String nama;
    int harga;

    MenuItem(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}
public class Driver1 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, MenuItem> menu = new HashMap<>();

        menu.put("NGS", new MenuItem("Nasi Goreng Spesial", 15000));
        menu.put("AP", new MenuItem("Ayam Penyet", 20000));
        menu.put("SA", new MenuItem("Sate Ayam (10 Tusuk)", 25000));
        menu.put("BU", new MenuItem("Bakso Urat", 18000));
        menu.put("MAP", new MenuItem("Mie Ayam Pangsit", 15000));
        menu.put("GG", new MenuItem("Gado-Gado", 15000));
        menu.put("SAM", new MenuItem("Soto Ayam", 17000));
        menu.put("RD", new MenuItem("Rendang Daging", 25000));
        menu.put("IB", new MenuItem("Ikan Bakar", 35000));
        menu.put("NUK", new MenuItem("Nasi Uduk Komplit", 20000));

        List<String> listNama = new ArrayList<>();
        List<Integer> listPorsi = new ArrayList<>();
        List<Integer> listHarga = new ArrayList<>();
        List<Integer> listTotal = new ArrayList<>();

        int grandTotal = 0;

        while (true) {

            String kode = sc.next().toUpperCase();

            if (kode.equals("END")) break;

            if (!menu.containsKey(kode)) {
                System.out.println("Kode tidak ada!");
                continue;
            }

            int porsiButet = sc.nextInt();

            int totalPorsi = porsiButet + (porsiButet * 2); // rasio 2:1

            MenuItem item = menu.get(kode);

            int totalHarga = totalPorsi * item.harga;

            listNama.add(item.nama);
            listPorsi.add(totalPorsi);
            listHarga.add(item.harga);
            listTotal.add(totalHarga);

            grandTotal += totalHarga;
        }

     
        // HITUNG DISKON
      
        double diskon = 0;

        if (grandTotal >= 500000) diskon = 0.25;
        else if (grandTotal >= 400000) diskon = 0.20;
        else if (grandTotal >= 300000) diskon = 0.15;
        else if (grandTotal >= 200000) diskon = 0.10;
        else if (grandTotal >= 100000) diskon = 0.05;

        int totalBayar = (int)(grandTotal - (grandTotal * diskon));


        // OUTPUT BILL

        System.out.println("\n===== BILL WARUNG =====");
        System.out.printf("%-25s %-6s %-10s %-10s\n",
                "Nama Makanan","Porsi","Harga","Total");
         System.out.println("=========================================================");

        for (int i = 0; i < listNama.size(); i++) {
            System.out.printf("%-25s %-6d %-10d %-10d\n",
                    listNama.get(i),
                    listPorsi.get(i),
                    listHarga.get(i),
                    listTotal.get(i));
        }

        System.out.println("=========================================================");
        System.out.println("Total Pembayaran :                          " + totalBayar);

        sc.close();
    }
}