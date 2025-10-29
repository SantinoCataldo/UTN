package Ej2;

public class Main {
    public static void main(String[] args) {
        Persona persona = Persona.cargarDesdeJson("persona.json");
        if (persona != null) {
            System.out.println("Persona cargada desde persona.json:");
            System.out.println(persona);
        }
    }
}
