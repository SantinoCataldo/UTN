package ej3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> flota = new ArrayList<>();

        flota.add(new Automovil("Toyota", "Corolla", 160, 5));
        flota.add(new Camion("Volvo", "FH", 120, 18));
        flota.add(new Autobus("Mercedes-Benz", "Sprinter", 140, 20));
        flota.add(new Bicicleta("Giant", "Escape 3", 35));

        for (Vehiculo v : flota) {
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Velocidad máxima: " + v.getVelocidadMaxima() + " km/h");
            if (v instanceof VehiculoDePasajeros) {
                System.out.println("Tipo: Vehículo de pasajeros");
                System.out.println("Capacidad de pasajeros: " + ((VehiculoDePasajeros) v).getCantidadPasajeros());
            } else if (v instanceof VehiculoDeCarga) {
                System.out.println("Tipo: Vehículo de carga");
                System.out.println("Capacidad de carga: " + ((VehiculoDeCarga) v).getCapacidadCarga() + " toneladas");
            } else {
                System.out.println("Tipo: Vehículo básico 1 pasajero");
            }
            System.out.println("-----------------------------");
        }
    }
}
