import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;

public class JsonParser {

    public static void guardarViajesEnJSON(String archivo, ArrayList<Viajes> viajes) {
        JSONArray viajesArray = new JSONArray();

        for (Viajes viaje : viajes) {
            JSONObject viajeJSON = new JSONObject();
            viajeJSON.put("id", viaje.getId());
            viajeJSON.put("patenteVehiculo", viaje.getPatenteVehiculo());
            viajeJSON.put("dniChofer", viaje.getDniChofer());
            viajeJSON.put("fechaSalida", viaje.getFechaSalida());
            viajeJSON.put("duracion", viaje.getDuracion());
            viajeJSON.put("lugarSalida", viaje.getLugarSalida());
            viajeJSON.put("destino", viaje.getDestino());
            viajeJSON.put("estado", viaje.getEstado().toString());

            JSONArray pasajerosArray = new JSONArray();
            for (Pasajeros pasajero : viaje.getListaPasajeros()) {
                JSONObject pasajeroJSON = new JSONObject();
                pasajeroJSON.put("dni", pasajero.getDni());
                pasajeroJSON.put("nombre", pasajero.getNombre());
                pasajeroJSON.put("asientoAsignado", pasajero.getAsientoAsignado());
                pasajerosArray.put(pasajeroJSON);
            }
            viajeJSON.put("listaPasajeros", pasajerosArray);

            viajesArray.put(viajeJSON);
        }

        try (FileWriter file = new FileWriter(archivo)) {
            file.write(viajesArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}