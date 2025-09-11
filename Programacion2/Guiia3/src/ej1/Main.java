package ej1;

public class Main {
    public static void main(String[] args) {
        Autobus autobus = new Autobus(12, 50);
        Tranvia tranvia = new Tranvia("Jujuy-Misiones", 120);
        Bicicleta bicicleta = new Bicicleta("BIC12345");

        //Autobus
        autobus.arrancar();
        System.out.println("Tipo: " + autobus.getTipoTransporte());
        System.out.println("Capacidad: " + autobus.obtenerCapacidad());
        autobus.detener();
        System.out.println();

        //Tranvia
        tranvia.arrancar();
        System.out.println("Tipo: " + tranvia.getTipoTransporte());
        System.out.println("Capacidad: " + tranvia.obtenerCapacidad());
        tranvia.detener();
        System.out.println();

        // Bicicleta
        bicicleta.arrancar();
        System.out.println("Tipo: " + bicicleta.getTipoTransporte());
        System.out.println("Capacidad: " + bicicleta.obtenerCapacidad());
        bicicleta.detener();
    }
}