package Ej4;

import org.json.JSONObject;

public class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("titulo", titulo);
        json.put("autor", autor);
        return json;
    }

    public static Libro fromJson(JSONObject json) {
        return new Libro(json.getString("titulo"), json.getString("autor"));
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
