public class Viaje {
    private static int contadorId = 1;
    private int id;
    private Vehiculo vehiculo;
    private Chofer chofer;
    private int cantidadPasajerosOCarga;
    private String destino;
    private double distanciaKms;
    private double tarifa;

    public Viaje(Vehiculo vehiculo, Chofer chofer, int cantidadPasajerosOCarga,
                 String destino, double distanciaKms, double tarifa) {
        this.id = contadorId++;
        this.vehiculo = vehiculo;
        this.chofer = chofer;
        this.cantidadPasajerosOCarga = cantidadPasajerosOCarga;
        this.destino = destino;
        this.distanciaKms = distanciaKms;
        this.tarifa = tarifa;
    }

    // Getters
    public int getId() { return id; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public Chofer getChofer() { return chofer; }
    public int getCantidadPasajerosOCarga() { return cantidadPasajerosOCarga; }
    public String getDestino() { return destino; }
    public double getDistanciaKms() { return distanciaKms; }
    public double getTarifa() { return tarifa; }


    public String getPatente() { return vehiculo.getPatente(); }
    public int getDniChofer() { return chofer.getDni(); }
}