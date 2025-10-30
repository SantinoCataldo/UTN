public class PersonajeNoEncontradoException extends Exception {
    private String nombrePersonaje;

    public PersonajeNoEncontradoException(String nombrePersonaje) {
        super("El personaje \"" + nombrePersonaje + "\" no se encontró en el registro.");
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
}
