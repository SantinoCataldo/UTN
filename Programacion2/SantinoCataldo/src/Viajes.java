import java.util.ArrayList;

public class Viajes {
    private int id;
    private String patenteVehiculo;
    private int dniChofer;
    private String fechaSalida;
    private int duracion;
    private String lugarSalida;
    private String destino;
    private ArrayList<Pasajeros> listaPasajeros;
    private Estado estado;

    public Viajes(int id, String patenteVehiculo, int dniChofer, String fechaSalida, int duracion, String lugarSalida, String destino) {
        this.id = id;
        this.patenteVehiculo = patenteVehiculo;
        this.dniChofer = dniChofer;
        this.fechaSalida = fechaSalida;
        this.duracion = duracion;
        this.lugarSalida = lugarSalida;
        this.destino = destino;
        this.listaPasajeros = new ArrayList<>();
        this.estado = Estado.PENDIENTE;
    }

    public void agregarPasajero(Pasajeros pasajero) throws AccionImposibleEx {
        if (listaPasajeros.contains(pasajero)) {
            throw new AccionImposibleEx("El pasajero ya está registrado o el asiento está ocupado");
        }
        listaPasajeros.add(pasajero);
    }

    public void cambiarEstado(Estado nuevoEstado) throws AccionImposibleEx {
        if (nuevoEstado == Estado.EN_CURSO && estado != Estado.PENDIENTE) {
            throw new AccionImposibleEx("El viaje debe estar en estado PENDIENTE para pasar a EN CURSO");
        }
        if (nuevoEstado == Estado.FINALIZADO && estado != Estado.EN_CURSO) {
            throw new AccionImposibleEx("El viaje debe estar en estado EN CURSO para pasar a FINALIZADO");
        }
        this.estado = nuevoEstado;
    }

    public int getId() {
        return id;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public int getDniChofer() {
        return dniChofer;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public String getDestino() {
        return destino;
    }

    public ArrayList<Pasajeros> getListaPasajeros() {
        return listaPasajeros;
    }

    public Estado getEstado() {
        return estado;
    }

    public String toString() {
        return "ID: " + id + " Patente Vehiculo: " + patenteVehiculo + " DNI Chofer: " + dniChofer + " Fecha Salida: " + fechaSalida + " Duracion: " + duracion + " Lugar Salida: " + lugarSalida + " Destino: " + destino + " Estado: " + estado + "\n";
    }
}
