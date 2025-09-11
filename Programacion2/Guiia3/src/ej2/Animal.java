package ej2;

public abstract class Animal {
    protected String nombre;
    protected String estado;

    public Animal(String nombre) {
        this.nombre = nombre;
        this.estado = "Normal";
    }

    public abstract void comunicar(String situacion);

    public void comer() {
        estado = "Comiendo";
        System.out.println(nombre + " está comiendo.");
    }

    public void dormir() {
        estado = "Durmiendo";
        System.out.println(nombre + " está durmiendo.");
    }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }
}

