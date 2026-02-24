import java.util.Scanner;

public class Driver2 {  
          public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input jumlah data
        System.out.print("Jumlah data: ");
        int N = sc.nextInt();
        sc.nextLine();

        // input nilai awal
        System.out.print("Nilai awal: ");
        int nilaiAwal = sc.nextInt();
        sc.nextLine();

        String[] kode = new String[N];

        // input kodenama
        for(int i = 0; i < N; i++){
            System.out.print("Kodenama ke-" + (i+1) + ": ");
            kode[i] = sc.nextLine();
        }

        int currentNilai = nilaiAwal;
        int total = 0;

        // ====== HEADER TABEL ======
        System.out.println("\n=================================");
        System.out.printf("| %-10s | %-10s |\n", "Kodenama", "Nilai");
        System.out.println("=================================");

        for(int i = 0; i < N; i++){

            // tampilkan isi tabel
            System.out.printf("| %-10s | %-10d |\n", kode[i], currentNilai);

            total += currentNilai;

            // pola deret -10 +15 -10 +15 ...
            if(i % 2 == 0){
                currentNilai -= 10;
            } else {
                currentNilai += 15;
            }
        }

        System.out.println("=================================");
        System.out.printf("| %-10s | %-10d |\n", "TOTAL", total);
        System.out.println("=================================");

        sc.close();
    }
}
