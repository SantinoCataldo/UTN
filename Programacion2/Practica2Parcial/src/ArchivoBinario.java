import java.io.*;

public class ArchivoBinario {

    public static void guardarNaves(StarWarsRegistro<Personaje> registro, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            System.out.println("\nGuardando naves en el archivo binario...");
            for (Personaje personaje : registro.listarPersonajes()) {
                for (Amigo amigo : personaje.getAmigos()) {
                    if (amigo.getNave() != null) {
                        oos.writeObject(amigo.getNave());
                    }
                }
            }
            System.out.println("Naves guardadas exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarNaves(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            System.out.println("\nNaves en el archivo binario:");
            while (true) {
                try {
                    Nave nave = (Nave) ois.readObject();
                    System.out.println(nave);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
