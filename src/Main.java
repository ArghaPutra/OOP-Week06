import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static List<Barang> daftarBarang = new ArrayList<>();
    static List<Order> daftarPesanan = new ArrayList<>();
    static int seqId = 1;

    public static void main(String[] args) {
        // Seed awal
        daftarBarang.add(new Handphone(seqId++,"Samsung S9+ Hitam",14499000,10,"Hitam"));
        daftarBarang.add(new Handphone(seqId++,"iPhone 17 Hitam",17999000,10,"Hitam"));
        daftarBarang.add(new Voucher(seqId++,"Google Play",20000,100,0.1));

        while (true) {
            System.out.println("-----------Menu Toko Voucher & HP-----------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Barang Baru");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            String pilih = in.nextLine();

            switch (pilih) {
                case "1" -> pesanBarang();
                case "2" -> lihatPesanan();
                case "3" -> barangBaru();
                case "0" -> { return; }
                default -> System.out.println("Pilihan tidak sesuai");
            }
        }
    }

    static Barang findBarang(int id) {
        return daftarBarang.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    static void barangBaru() {
        System.out.print("Voucher / Handphone (V/H): ");
        String jenis = in.nextLine().trim().toLowerCase();
        try {
            if (jenis.equals("v")) {
                System.out.print("Nama: "); String nama = in.nextLine();
                System.out.print("Harga: "); double harga = Double.parseDouble(in.nextLine());
                System.out.print("Stok: "); int stok = Integer.parseInt(in.nextLine());
                System.out.print("PPN: "); double pajak = Double.parseDouble(in.nextLine());
                daftarBarang.add(new Voucher(seqId++, nama, harga, stok, pajak));
                System.out.println("Voucher telah berhasil diinput");
            } else if (jenis.equals("h")) {
                System.out.print("Nama: "); String nama = in.nextLine();
                System.out.print("Harga: "); double harga = Double.parseDouble(in.nextLine());
                System.out.print("Stok: "); int stok = Integer.parseInt(in.nextLine());
                System.out.print("Warna: "); String warna = in.nextLine();
                daftarBarang.add(new Handphone(seqId++, nama, harga, stok, warna));
                System.out.println("Handphone telah berhasil diinput");
            } else {
                System.out.println("Jenis tidak valid");
            }
        } catch(Exception e){ System.out.println("Input salah"); }
    }

    static void pesanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Barang tidak tersedia");
            return;
        }
        daftarBarang.forEach(b ->
                System.out.printf("ID %d: %s%n", b.getId(), b.getDeskripsi())
        );

        System.out.print("Pesan Barang (ID/0=cancel): ");
        int id = Integer.parseInt(in.nextLine());
        if (id == 0) return;

        Barang barang = findBarang(id);
        if (barang == null) { System.out.println("Pemilihan barang tidak sesuai"); return; }

        System.out.print("Masukkan Jumlah: ");
        int jml = Integer.parseInt(in.nextLine());
        if (jml <= 0 || jml > barang.getStock()) {
            System.out.println("Stok tidak mencukupi jumlah pesanan");
            return;
        }

        double total = barang.getHargaJual(jml);
        System.out.printf("%d @ %s total harga %.0f%n", jml, barang.getNama(), total);

        System.out.print("Masukkan jumlah uang: ");
        double bayar = Double.parseDouble(in.nextLine());
        if (bayar < total) {
            System.out.println("Jumlah Uang tidak mencukupi");
            return;
        }

        barang.minusStok(jml);
        daftarPesanan.add(new Order(seqId++, barang, jml));
        System.out.println("Berhasil dipesan");
    }

    static void lihatPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("(Belum ada pesanan)");
            return;
        }
        daftarPesanan.forEach(System.out::println);
    }
}
