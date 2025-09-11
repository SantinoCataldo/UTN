package ej2;

public class Murcielago extends Animal implements Volar, Colgarse {
    public Murcielago(String nombre) {
        super(nombre);
    }

    @Override
    public void comunicar(String situacion) {
        if ("feliz".equals(situacion)) {
            System.out.println(nombre + " dice: Squeak squeak!");
        } else if ("peligro".equals(situacion)) {
            System.out.println(nombre + " dice: Squeak squeak squeak squeak!");
        } else {
            System.out.println(nombre + " dice: Squeak?");
        }
    }

    @Override
    public void volar() {
        estado = "Volando";
        System.out.println(nombre + " está volando en la oscuridad");
    }

    @Override
    public void colgarse() {
        estado = "Colgado";
        System.out.println(nombre + " está colgado boca abajo en la cueva");
    }
}
