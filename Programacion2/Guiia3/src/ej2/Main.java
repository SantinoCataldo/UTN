package ej2;

public class Main {
    public static void main(String[] args) {
        Pato pato = new Pato("Pato Mastantuono");
        Murcielago murcielago = new Murcielago("Murciélago Esteban");
        Pez pez = new Pez("Pez Javier");

        // Pato
        System.out.println("--- Pato ---");
        pato.comer();
        pato.comunicar("feliz");
        pato.caminar();
        System.out.println("Estado: " + pato.getEstado());
        pato.volar();
        System.out.println("Estado: " + pato.getEstado());
        pato.nadar();
        System.out.println("Estado: " + pato.getEstado());
        pato.dormir();
        pato.comunicar("peligro");
        System.out.println();

        // Murciélago
        System.out.println("--- Murciélago ---");
        murcielago.comer();
        murcielago.comunicar("feliz");
        murcielago.volar();
        System.out.println("Estado: " + murcielago.getEstado());
        murcielago.colgarse();
        System.out.println("Estado: " + murcielago.getEstado());
        murcielago.dormir();
        murcielago.comunicar("peligro");
        System.out.println();

        // Pez
        System.out.println("--- Pez ---");
        pez.comer();
        pez.comunicar("feliz");
        pez.nadar();
        System.out.println("Estado: " + pez.getEstado());
        pez.dormir();
        pez.comunicar("peligro");
    }
}