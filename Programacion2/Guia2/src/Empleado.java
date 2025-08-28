abstract  class Empleado {
    String nombre;

    public  Empleado(String nombre) {
        this.nombre = nombre;
    }

    abstract double calcularPago();
}

class EmpleadoTiempoCompleto extends Empleado {
    double salarioMensual;

    EmpleadoTiempoCompleto(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    double calcularPago() {
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

    double calcularPago() {
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

    double calcularPago() {
        return horasTrabajadas * tarifaPorProyecto;
    }
}
