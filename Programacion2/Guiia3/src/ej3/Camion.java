package ej3;

public class Camion implements VehiculoDeCarga {
    private String marca;
    private String modelo;
    private int velocidadMaxima;
    private double capacidadCarga;

    public Camion(String marca, String modelo, int velocidadMaxima, double capacidadCarga) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String getMarca() { return marca; }
    @Override
    public String getModelo() { return modelo; }
    @Override
    public int getVelocidadMaxima() { return velocidadMaxima; }
    @Override
    public double getCapacidadCarga() { return capacidadCarga; }
}

