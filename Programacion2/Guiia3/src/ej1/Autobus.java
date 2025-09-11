package ej1;

public class Autobus implements Transporte {
    private int numeroLinea;
    private int capacidad;
    private TipoTransporte tipoTransporte;

    public Autobus(int numeroLinea, int capacidad) {
        this.numeroLinea = numeroLinea;
        this.capacidad = capacidad;
        this.tipoTransporte = TipoTransporte.AUTOBUS;
    }

    @Override
    public void arrancar() {
        System.out.println("El autobús de la línea " + numeroLinea + " ha arrancado.");
    }

    @Override
    public void detener() {
        System.out.println("El autobús de la línea " + numeroLinea + " se ha detenido.");
    }

    @Override
    public int obtenerCapacidad() {
        return capacidad;
    }

    public void AnunciarParada(String nombreParada) {
        System.out.println("Próxima parada: " + nombreParada);
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }
}
