package ej1;

public class Tranvia implements Transporte {
    private String ruta;
    private int capacidad;
    private TipoTransporte tipoTransporte;

    public Tranvia(String ruta, int capacidad) {
        this.ruta = ruta;
        this.capacidad = capacidad;
        this.tipoTransporte = TipoTransporte.TRANVIA;
    }

    @Override
    public void arrancar() {
        System.out.println("El tranvía de la ruta " + ruta + " ha arrancado.");
    }

    @Override
    public void detener() {
        System.out.println("El tranvía de la ruta " + ruta + " se ha detenido.");
    }

    @Override
    public int obtenerCapacidad() {
        return capacidad;
    }

    public void cambiarVia(int nuevaVia) {
        System.out.println("El tranvía ha cambiado a la vía " + nuevaVia);
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }
}
