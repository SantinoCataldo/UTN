package ej3;

public class Cancion  {
    private String nombre;
    private int duracion;
    private Genero genero;
    private Artista artistaInvitado;
    private Album album;

    public Cancion(String nombre, int duracion, Genero genero, Artista artistaInvitado, Album album) {
        this.album = album;
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.artistaInvitado = artistaInvitado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public Artista getArtistaInvitado() {
        return artistaInvitado;
    }

    public Album getAlbum() {
        return album;
    }
}
