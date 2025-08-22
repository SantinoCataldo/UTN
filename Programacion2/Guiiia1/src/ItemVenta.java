public class ItemVenta {
    private int id;
    private static int contId = 0;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public ItemVenta(String descripcion, int cantidad, double precioUnitario){
        this.id = contId++;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double precioTotal(){
        return precioUnitario * cantidad;
    }

    public void muestraDatos(){
        System.out.println("ItemVenta[id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", pUnitario=" + precioUnitario + ", pTotal=" + (cantidad * precioUnitario) + "]");
    }
}
