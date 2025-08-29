public abstract class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPago();
}

class EmpleadoTiempoCompleto extends Empleado {
    double salarioMensual;

    EmpleadoTiempoCompleto(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    public double calcularPago() {
        return salarioMensual;
    }
}

class EmpleadoPorHoras extends Empleado {
    double horasTrabajadas;
    double tarifaPorHora;

    EmpleadoPorHoras(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }
}

class EmpleadoContratista extends Empleado {
    double horasTrabajadas;
    double tarifaPorProyecto;

    EmpleadoContratista(String nombre, double horasTrabajadas, double tarifaPorProyecto) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorProyecto = tarifaPorProyecto;
    }

    public double calcularPago() {
        return horasTrabajadas * tarifaPorProyecto;
    }
}
