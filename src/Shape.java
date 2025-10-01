public class Shape {
    protected int width, height;

    public Shape() {
        System.out.println("Shape Created");
    }

    public void setValue(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
