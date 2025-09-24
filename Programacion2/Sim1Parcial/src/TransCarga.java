public class TransCarga extends Vehiculo implements Mantenimiento{
    private double pesoMaximo;
    private Medida medida;

    public TransCarga(double pesoMaximo, Medida medida, String modelo, Marcas marca, String patente, double velocidadRecomendada, double kilometraje) {
        super(modelo, marca, patente, velocidadRecomendada, kilometraje);
        this.pesoMaximo = pesoMaximo;
        this.medida = medida;
    }

    // Getters
    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    @Override
    public void realizarMantenimiento(double nuevaVelocidad, double nuevoKilometraje, int nuevaCantidadCarga) {
        setVelocidadRecomendada(nuevaVelocidad);
        setKilometraje(nuevoKilometraje);
        this.pesoMaximo = nuevaCantidadCarga;
    }
}
