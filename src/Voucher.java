public class Voucher extends Barang {
    private double pajak;

    public Voucher(int id, String nama, double harga, int stock, double pajak) {
        super(id, nama, harga, stock);
        this.pajak = pajak;
    }

    @Override
    public double getHargaJual(int jumlah) {
        return (harga + harga * pajak) * jumlah;
    }

    @Override
    public String getDeskripsi() {
        return String.format("%s (stok:%d) harga: %.0f + PPN %.2f",
                nama, stock, harga, pajak);
    }
}
