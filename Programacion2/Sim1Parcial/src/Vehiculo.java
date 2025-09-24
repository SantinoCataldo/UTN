public class Vehiculo {
    private String modelo;
    private Marcas marca;
    private String patente;
    private double velocidadRecomendada;
    private double kilometraje;

    public Vehiculo(String modelo, Marcas marca, String patente, double velocidadRecomendada, double kilometraje) {
        this.modelo = modelo;
        this.marca = marca;
        this.patente = patente;
        this.velocidadRecomendada = velocidadRecomendada;
        this.kilometraje = kilometraje;
    }

    // Getters and Setters
    public String getModelo() { return modelo ;};
    public void setModelo(String modelo) { this.modelo = modelo;};
    public Marcas getMarca() { return marca;};
    public void setMarca(Marcas marca) { this.marca = marca;};
    public String getPatente() { return patente;};
    public void setPatente(String patente) { this.patente = patente;};
    public double getVelocidadRecomendada() { return velocidadRecomendada;};
    public void setVelocidadRecomendada(double velocidadRecomendada) { this.velocidadRecomendada = velocidadRecomendada;};
    public double getKilometraje() { return kilometraje;};
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje;};
}