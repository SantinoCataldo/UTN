package ej3;

public class Automovil implements VehiculoDePasajeros {
    private String marca;
    private String modelo;
    private int velocidadMaxima;
    private int cantidadPasajeros;

    public Automovil(String marca, String modelo, int velocidadMaxima, int cantidadPasajeros) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String getMarca() { return marca; }
    @Override
    public String getModelo() { return modelo; }
    @Override
    public int getVelocidadMaxima() { return velocidadMaxima; }
    @Override
    public int getCantidadPasajeros() { return cantidadPasajeros; }
}

