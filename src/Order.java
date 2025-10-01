public class Order {
    private int id;
    private Barang barang;
    private int jumlah;

    public Order(int id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return String.format("ID %d - %d @ %s = %.0f",
                id, jumlah, barang.getNama(), barang.getHargaJual(jumlah));
    }
}
