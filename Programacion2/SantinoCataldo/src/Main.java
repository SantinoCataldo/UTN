import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String flotaYEmpleados = JSONUtiles.downloadJSON("flota_y_empleados");
            JSONObject data = new JSONObject(flotaYEmpleados);

            Contenedor<Vehiculos> vehiculosCont = new Contenedor<>();
            Contenedor<Empleados> empleadosCont = new Contenedor<>();

            // Cargar vehículos en el contenedor
            JSONArray vehiculosArray = data.getJSONArray("vehiculos");
            for (int i = 0; i < vehiculosArray.length(); i++) {
                JSONObject vehiculo = vehiculosArray.getJSONObject(i);
                vehiculosCont.agregar(new Vehiculos(
                        vehiculo.getString("patente"),
                        vehiculo.getString("marca"),
                        vehiculo.getString("modelo"),
                        vehiculo.getInt("capacidad"),
                        vehiculo.getInt("anio")
                ));
            }

            // Cargar empleados en el contenedor
            JSONArray empleadosArray = data.getJSONArray("empleados");
            for (int i = 0; i < empleadosArray.length(); i++) {
                JSONObject empleado = empleadosArray.getJSONObject(i);
                empleadosCont.agregar(new Empleados(
                        empleado.getInt("dni"),
                        empleado.getString("nombre"),
                        empleado.getString("puesto"),
                        empleado.getInt("antiguedad")
                ));
            }

            ArrayList<Viajes> viajes = new ArrayList<>();
            Viajes viaje = new Viajes(1, "AA123BB", 31222333, "01-06-2025", 8, "Buenos Aires", "Rosario");

            // Validar que la patente exista
            if (!vehiculosCont.existe(v -> v.getPatente().equals("AA123BB"))) {
                throw new AccionImposibleEx("La patente no existe en el sistema");
            }

            //Validar que el chofer exista y sea chofer
            if (!empleadosCont.existe(e -> e.getDni() == 31222333 && e.getPuesto().equalsIgnoreCase("Chofer"))) {
                throw new AccionImposibleEx("El DNI del chofer no existe o no es un chofer");
            }

            viajes.add(viaje);

            // Agregar un pasajeros al viaje
            Pasajeros pasajero = new Pasajeros(46828053, "Pedro", "Adelante Derecha");
            Pasajeros pasajero2 = new Pasajeros(46828052, "Miguel", "Atras Izquierda");
            viaje.agregarPasajero(pasajero);
            viaje.agregarPasajero(pasajero2);

            viaje.cambiarEstado(Estado.EN_CURSO);

            viaje.cambiarEstado(Estado.FINALIZADO);

            JsonParser.guardarViajesEnJSON("viajes.txt", viajes);

        } catch (ElementoDuplicadoEx | AccionImposibleEx e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}