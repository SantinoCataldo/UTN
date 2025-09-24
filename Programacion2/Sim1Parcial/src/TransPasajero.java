public class TransPasajero extends Vehiculo implements Mantenimiento{
    private int numPasajeros;
    private Categoria categoria;

    public TransPasajero(int numPasajeros, Categoria categoria, String modelo, Marcas marca, String patente, double velocidadRecomendada, double kilometraje) {
        super(modelo, marca, patente, velocidadRecomendada, kilometraje);
        this.numPasajeros = numPasajeros;
        this.categoria = categoria;
    }

    // Getters and Setters
    public int getNumPasajeros() { return numPasajeros; }
    public void setNumPasajeros(int numPasajeros) { this.numPasajeros=numPasajeros; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria=categoria; }

    @Override
    public void realizarMantenimiento(double nuevaVelocidad, double nuevoKilometraje, int nuevaCantidadPasajeros) {
        setVelocidadRecomendada(nuevaVelocidad);
        setKilometraje(nuevoKilometraje);
        this.numPasajeros = nuevaCantidadPasajeros;
    }
}
