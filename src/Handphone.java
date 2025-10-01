public class Handphone extends Barang {
    private String warna;

    public Handphone(int id, String nama, double harga, int stock, String warna) {
        super(id, nama, harga, stock);
        this.warna = warna;
    }

    @Override
    public String getDeskripsi() {
        return String.format("%s warna %s (stok:%d) harga: %.0f",
                nama, warna, stock, harga);
    }
}
