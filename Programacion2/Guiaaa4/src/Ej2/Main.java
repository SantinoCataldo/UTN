package Ej2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Sexo (H/M): ");
        char sexo = sc.next().charAt(0);
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        System.out.print("Altura (m): ");
        double altura = sc.nextDouble();

        Persona p1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona p2 = new Persona(nombre, edad, sexo);
        Persona p3 = new Persona();
        p3.setNombre("Ejemplo");
        p3.setEdad(30);
        p3.setSexo('M');
        p3.setPeso(65);
        p3.setAltura(1.70);

        Map<String, Persona> personas = new HashMap<>();
        personas.put(p1.getDni(), p1);
        personas.put(p2.getDni(), p2);
        personas.put(p3.getDni(), p3);

        for (Persona p : personas.values()) {
            System.out.println(p);
            int imc = p.calcularIMC();
            switch (imc) {
                case -1 -> System.out.println("Está por debajo de su peso ideal.");
                case 0 -> System.out.println("Está en su peso ideal.");
                case 1 -> System.out.println("Tiene sobrepeso.");
            }
            System.out.println(p.esMayorDeEdad() ? "Es mayor de edad." : "No es mayor de edad.");
            System.out.println();
        }
    }
}
