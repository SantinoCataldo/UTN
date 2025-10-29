package Ej1;

import java.util.ArrayList;
import java.util.List;

public class Almacenamiento<T> {

    private final List<T> items;

    public Almacenamiento() {
        this.items = new ArrayList<>();
    }

    public void agregar(T item) {
        this.items.add(item);
    }

    public boolean eliminar(T item) {
        return this.items.remove(item);
    }

    public T buscar(T item) {
        int index = this.items.indexOf(item);
        return (index != -1) ? this.items.get(index) : null;
    }

    public void imprimirItems() {
        System.out.println("Contenido del almacenamiento:");
        for (T item : items) {
            System.out.println("- " + item);
        }
        System.out.println("---");
    }
}