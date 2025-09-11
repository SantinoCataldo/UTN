package ej2;

public class Pato extends Animal implements Caminar, Volar, Nadar {
    public Pato(String nombre) {
        super(nombre);
    }

    @Override
    public void comunicar(String situacion) {
        if ("feliz".equals(situacion)) {
            System.out.println(nombre + " dice: ¡Cuac cuac!");
        } else if ("peligro".equals(situacion)) {
            System.out.println(nombre + " dice: ¡Cuaaaaaaac!");
        } else {
            System.out.println(nombre + " dice: Cuac?");
        }
    }

    @Override
    public void caminar() {
        estado = "Caminando";
        System.out.println(nombre + " está caminando.");
    }

    @Override
    public void volar() {
        estado = "Volando";
        System.out.println(nombre + " está volando bajito.");
    }

    @Override
    public void nadar() {
        estado = "Nadando";
        System.out.println(nombre + " está nadando bajo el agua");
    }
}

