import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StarWarsJsonParser {

    public static List<Personaje> parsePersonajes(String json) {
        List<Personaje> personajes = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray personajesArray = jsonObject.getJSONArray("personajes");

        for (int i = 0; i < personajesArray.length(); i++) {
            JSONObject personajeJson = personajesArray.getJSONObject(i);

            JSONObject maestroJson = personajeJson.getJSONObject("maestro");
            Maestro maestro = new Maestro(
                    maestroJson.getString("nombre"),
                    maestroJson.getBoolean("es_jedi"),
                    new ArrayList<>()
            );

            JSONArray amigosArray = personajeJson.getJSONArray("amigos");
            List<Amigo> amigos = new ArrayList<>();
            for (int j = 0; j < amigosArray.length(); j++) {
                JSONObject amigoJson = amigosArray.getJSONObject(j);
                Nave nave = null;
                if (!amigoJson.isNull("nave")) {
                    JSONObject naveJson = amigoJson.getJSONObject("nave");
                    nave = new Nave(naveJson.getString("nombre"), naveJson.getString("modelo"));
                }
                amigos.add(new Amigo(amigoJson.getString("nombre"), amigoJson.getBoolean("piloto"), nave));
            }

            JSONArray eventosArray = personajeJson.getJSONArray("eventos");
            List<Evento> eventos = new ArrayList<>();
            for (int j = 0; j < eventosArray.length(); j++) {
                JSONObject eventoJson = eventosArray.getJSONObject(j);
                eventos.add(new Evento(eventoJson.getString("nombre"), eventoJson.getInt("anio"), eventoJson.getBoolean("ganada")));
            }

            Personaje personaje = new Personaje(
                    personajeJson.getString("nombre"),
                    personajeJson.getInt("edad"),
                    personajeJson.getBoolean("jedi"),
                    personajeJson.getString("planeta_nacimiento"),
                    maestro,
                    amigos,
                    eventos
            );
            personajes.add(personaje);
        }
        return personajes;
    }
}
