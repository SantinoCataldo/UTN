public abstract class Persona {
    private String nombre;
    private String apellido;
    private String gmail;
    private String direccion;
    private int dni;

    public Persona(String nombre, String apellido, String gmail, String direccion, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.gmail = gmail;
        this.direccion = direccion;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGmail() {
        return gmail;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getDni() {
        return dni;
    }

    public abstract void mostrarDatos();
}

class Estudiante extends Persona {
    private int cuotaMensual;
    private int anioIngreso;
    private String carrera;

    public Estudiante(String nombre, String apellido, String gmail, String direccion, int dni, int cuotaMensual, int anioIngreso, String carrera) {
        super(nombre, apellido, gmail, direccion, dni);
        this.cuotaMensual = cuotaMensual;
        this.anioIngreso = anioIngreso;
        this.carrera = carrera;
    }

    public int getCuotaMensual() {
        return cuotaMensual;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Gmail: " + getGmail());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("DNI: " + getDni());
        System.out.println("Cuota Mensual: " + cuotaMensual);
        System.out.println("Año de Ingreso: " + anioIngreso);
        System.out.println("Carrera: " + carrera);
    }
}

class Staff extends Persona {
    private String turno;
    private double salario;


    public Staff(String nombre, String apellido, String gmail, String direccion, int dni, String turno, double salario) {
        super(nombre, apellido, gmail, direccion, dni);
        this.turno = turno;
        this.salario = salario;
    }

    public void mostrarDatos() {
        System.out.println("Turno: " + turno);
        System.out.println("Salario: " + salario);
    }
}
