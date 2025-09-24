public class TransEmpresariales extends Vehiculo {
    private int cantButacas;
    private int anioAdquisicion;

    public TransEmpresariales(int cantButacas, int anioAdquisicion, String modelo, Marcas marca, String patente, double velocidadRecomendada, double kilometraje) {
        super(modelo, marca, patente, velocidadRecomendada, kilometraje);
        this.cantButacas = cantButacas;
        this.anioAdquisicion = anioAdquisicion;
    }

    // Getters y Setters
    public int getCantButacas() {
        return cantButacas;
    }

    public void setCantButacas(int cantButacas) {
        this.cantButacas = cantButacas;
    }

    public int getAnioAdquisicion() {
        return anioAdquisicion;
    }

    public void setAnioAdquisicion(int anioAdquisicion) {
        this.anioAdquisicion = anioAdquisicion;
    }
}
