package ej3;

public class Album {
    private String titulo;
    private Artista artista;
    private int anio;

    public Album(String titulo, Artista artista, int anio) {
        this.titulo = titulo;
        this.artista = artista;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public int getAnio() {
        return anio;
    }
}
