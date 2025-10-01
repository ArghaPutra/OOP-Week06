public class Barang {
    protected int id, stock;
    protected double harga;
    protected String nama;

    public Barang(int id, String nama, double harga, int stock) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStock() { return stock; }

    public void minusStok(int jml) { stock -= jml; }
    public double getHargaJual(int jumlah) { return harga * jumlah; }
    public String getDeskripsi() {
        return String.format("%s (stok:%d) harga: %.0f", nama, stock, harga);
    }
}
