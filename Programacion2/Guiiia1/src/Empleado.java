public class Empleado {
    private int dni;
    private String nombre;
    private String apellido;
    private int salario;

    public Empleado (int dni, String nombre, String apellido, int salario){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public int salarioAnual(){
        return salario*12;
    }

    public void aumentoSalario(int aumento){
        int total = (salario*aumento/100)+salario;
        this.salario = total;
    }

    public void mostrarDatos(){
        System.out.println("dni: " + dni +" nombre: " + nombre + " apellido: " + apellido + " salario: " + salario);
    }

}
