import java.util.ArrayList;

public class Empresa {
    private ArrayList<Chofer> choferes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Viaje> viajes;

    public Empresa() {
        this.choferes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.viajes = new ArrayList<>();
    }

    // Métodos para choferes
    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    public Chofer buscarChoferPorDni(int dni) {
        for (Chofer chofer : choferes) {
            if (chofer.getDni() == dni) {
                return chofer;
            }
        }
        return null;
    }

    public int getCantidadChoferes() {
        return choferes.size();
    }

    public boolean quitarChofer(int dni) {
        Chofer chofer = buscarChoferPorDni(dni);
        if (chofer != null) {
            return choferes.remove(chofer);
        }
        return false;
    }

    // Métodos para vehículos
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return vehiculo;
            }
        }
        return null;
    }

    public boolean quitarVehiculo(String patente) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null) {
            return vehiculos.remove(vehiculo);
        }
        return false;
    }

    public boolean realizarMantenimiento(String patente, double nuevaVelocidad, double nuevoKilometraje, int nuevoValor) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null && vehiculo instanceof Mantenimiento) {
            ((Mantenimiento) vehiculo).realizarMantenimiento(nuevaVelocidad, nuevoKilometraje, nuevoValor);
            return true;
        }
        return false;
    }

    public String obtenerInformacionVehiculo(String patente) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null) {
            StringBuilder info = new StringBuilder();
            info.append("=== INFORMACIÓN DEL VEHÍCULO ===\n");
            info.append("Patente: ").append(vehiculo.getPatente()).append("\n");
            info.append("Modelo: ").append(vehiculo.getModelo()).append("\n");
            info.append("Marca: ").append(vehiculo.getMarca()).append("\n");
            info.append("Velocidad Recomendada: ").append(vehiculo.getVelocidadRecomendada()).append(" km/h\n");
            info.append("Kilometraje: ").append(vehiculo.getKilometraje()).append(" km\n");

            if (vehiculo instanceof TransPasajero) {
                TransPasajero tp = (TransPasajero) vehiculo;
                info.append("Tipo: Transporte de Pasajeros\n");
                info.append("Número de Pasajeros: ").append(tp.getNumPasajeros()).append("\n");
                info.append("Categoría: ").append(tp.getCategoria()).append("\n");
            } else if (vehiculo instanceof TransCarga) {
                TransCarga tc = (TransCarga) vehiculo;
                info.append("Tipo: Transporte de Carga\n");
                info.append("Peso Máximo: ").append(tc.getPesoMaximo()).append("\n");
                info.append("Medida: ").append(tc.getMedida()).append("\n");
            } else if (vehiculo instanceof TransEmpresariales) {
                TransEmpresariales te = (TransEmpresariales) vehiculo;
                info.append("Tipo: Transporte Empresarial\n");
                info.append("Cantidad de Butacas: ").append(te.getCantButacas()).append("\n");
                info.append("Año de Adquisición: ").append(te.getAnioAdquisicion()).append("\n");
            }

            return info.toString();
        }
        return "Vehículo no encontrado";
    }

    public String obtenerInformacionChofer(int dni) {
        Chofer chofer = buscarChoferPorDni(dni);
        if (chofer != null) {
            StringBuilder info = new StringBuilder();
            info.append("=== INFORMACIÓN DEL CHOFER ===\n");
            info.append("DNI: ").append(chofer.getDni()).append("\n");
            info.append("Nombre: ").append(chofer.getNombre()).append(" ").append(chofer.getApellido()).append("\n");
            info.append("Salario por KM: $").append(chofer.getSalarioKM()).append("\n");
            return info.toString();
        }
        return "Chofer no encontrado";
    }

    // Métodos para viajes
    public void registrarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public Viaje buscarViajePorId(int id) {
        for (Viaje viaje : viajes) {
            if (viaje.getId() == id) {
                return viaje;
            }
        }
        return null;
    }

    public String obtenerInformacionViaje(int id) {
        Viaje viaje = buscarViajePorId(id);
        if (viaje != null) {
            StringBuilder info = new StringBuilder();
            info.append("=== INFORMACIÓN DEL VIAJE ===\n");
            info.append("ID: ").append(viaje.getId()).append("\n");
            info.append("Destino: ").append(viaje.getDestino()).append("\n");
            info.append("Distancia: ").append(viaje.getDistanciaKms()).append(" km\n");
            info.append("Tarifa: $").append(viaje.getTarifa()).append("\n");
            info.append("Cantidad Pasajeros/Carga: ").append(viaje.getCantidadPasajerosOCarga()).append("\n");
            info.append("\n--- VEHÍCULO ---\n");
            info.append(obtenerInformacionVehiculo(viaje.getPatente()));
            info.append("\n--- CHOFER ---\n");
            info.append(obtenerInformacionChofer(viaje.getDniChofer()));
            return info.toString();
        }
        return "Viaje no encontrado";
    }

    public double calcularTiempoEstimado(int idViaje) {
        Viaje viaje = buscarViajePorId(idViaje);
        if (viaje != null && viaje.getVehiculo() != null) {
            double velocidad = viaje.getVehiculo().getVelocidadRecomendada();
            double distancia = viaje.getDistanciaKms();
            return distancia / velocidad;
        }
        return -1;
    }

    public double calcularPagoChofer(int idViaje) {
        Viaje viaje = buscarViajePorId(idViaje);
        if (viaje != null && viaje.getChofer() != null) {
            double salarioPorKm = viaje.getChofer().getSalarioKM();
            double distancia = viaje.getDistanciaKms();
            return salarioPorKm * distancia;
        }
        return -1;
    }

    public double calcularRecaudacionTotal() {
        double total = 0;
        for (Viaje viaje : viajes) {
            total += viaje.getTarifa();
        }
        return total;
    }
}