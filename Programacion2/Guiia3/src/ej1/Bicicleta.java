package ej1;

public class Bicicleta implements Transporte {
    private String numeroSerie;
    private TipoTransporte tipoTransporte;

    public Bicicleta(String numeroSerie) {
        this.numeroSerie = numeroSerie;
        this.tipoTransporte = TipoTransporte.BICICLETA;
    }

    @Override
    public void arrancar() {
        System.out.println("La bicicleta con número de serie " + numeroSerie + " ha comenzado a moverse.");
    }

    @Override
    public void detener() {
        System.out.println("La bicicleta con número de serie " + numeroSerie + " se ha detenido.");
    }

    @Override
    public int obtenerCapacidad() {
        return 1;
    }

    public void ajustarAsiento(int altura){
        System.out.println("El asiento de la bicicleta con número de serie " + numeroSerie + " ha sido ajustado a una altura de " + altura);
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }
}
