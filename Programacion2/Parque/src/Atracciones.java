public abstract class Atracciones {
    private String nombre;
    private int codigo;
    private static int codigoCont = 1;
    private NivelIntensidad intensidad;
    private Estado estado;

    public Atracciones(String nombre, NivelIntensidad intensidad, Estado estado) {
        this.nombre = nombre;
        this.codigo = codigoCont++;
        this.intensidad = intensidad;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public NivelIntensidad getIntensidad() {
        return intensidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

class AtraccionInfantil extends Atracciones {
    private int edadMaxima;
    private int capacidadFila;
    private double duracion;

    public AtraccionInfantil(String nombre, NivelIntensidad intensidad, Estado estado, int edadMaxima, int capacidadFila, double duracion) {
        super(nombre, intensidad, estado);
        this.edadMaxima = edadMaxima;
        this.capacidadFila = capacidadFila;
        this.duracion = duracion;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public int getCapacidadFila() {
        return capacidadFila;
    }

    public double getDuracion() {
        return duracion;
    }

    public double obtenerMaximaEspera() {
        return capacidadFila * duracion;
    }
}

class JuegoAgua extends Atracciones {
    private double profundidad;
    private double pesoMaximo;
    private int maxParticipantes;

    public JuegoAgua(String nombre, NivelIntensidad intensidad, Estado estado, double profundidad, double pesoMaximo, int maxParticipantes) {
        super(nombre, intensidad, estado);
        this.profundidad = profundidad;
        this.pesoMaximo = pesoMaximo;
        this.maxParticipantes = maxParticipantes;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public double obtenerPesoTotalMaximo() {
        return pesoMaximo * maxParticipantes;
    }
}

class MontaniaRusa extends Atracciones {
    private int loopings;
    private double longitud;
    private double velocidadMaxima;

    public MontaniaRusa(String nombre, NivelIntensidad intensidad, Estado estado, int loopings, double longitud, double velocidadMaxima) {
        super(nombre, intensidad, estado);
        this.loopings = loopings;
        this.longitud = longitud;
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getLoopings() {
        return loopings;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double obtenerTiempoMaximo() {
        if (velocidadMaxima == 0) return 0;
        return longitud / velocidadMaxima;
    }
}
