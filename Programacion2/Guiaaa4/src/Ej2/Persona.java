package Ej2;

import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    private static final char SEXO_DEF = 'H';
    private static final int BAJO_PESO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;

    public Persona() {
        this("", 0, SEXO_DEF, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.dni = generaDNI();
    }

    public int calcularIMC() {
        if (altura <= 0) return BAJO_PESO;
        double imc = peso / (altura * altura);
        if (imc < 20) return BAJO_PESO;
        if (imc <= 25) return PESO_IDEAL;
        return SOBREPESO;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        return (sexo == 'H' || sexo == 'M') ? sexo : SEXO_DEF;
    }

    private String generaDNI() {
        Random rand = new Random();
        int num = 10000000 + rand.nextInt(90000000);
        char letra = calcularLetraDNI(num);
        return num + String.valueOf(letra);
    }

    private char calcularLetraDNI(int num) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(num % 23);
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setSexo(char sexo) { this.sexo = comprobarSexo(sexo); }
    public void setPeso(double peso) { this.peso = peso; }
    public void setAltura(double altura) { this.altura = altura; }

    public String getDni() { return dni; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + dni +
                ", Sexo: " + sexo + ", Peso: " + peso + ", Altura: " + altura;
    }
}
