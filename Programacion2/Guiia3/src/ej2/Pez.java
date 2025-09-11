package ej2;

public class Pez extends Animal implements Nadar {
    public Pez(String nombre) {
        super(nombre);
    }

    @Override
    public void comunicar(String situacion) {
        if ("feliz".equals(situacion)) {
            System.out.println(nombre + " dice: ¡Glub glub!");
        } else if ("peligro".equals(situacion)) {
            System.out.println(nombre + " dice: ¡Glub glub glub glub glub glub glub!");
        } else {
            System.out.println(nombre + " dice: Glub?");
        }
    }

    @Override
    public void nadar() {
        estado = "Nadando";
        System.out.println(nombre + " está nadando rapidamente esquivando algas y rocas");
    }
}
