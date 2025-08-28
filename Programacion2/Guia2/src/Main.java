import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar pagos");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println("Tipo de empleado (1=Tiempo completo, 2=Por horas, 3=Contratista):");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    if(tipo == 1) {
                        System.out.println("Salario mensual:");
                        double salario = sc.nextDouble();
                        empleados.add(new EmpleadoTiempoCompleto(nombre, salario));
                    } else if(tipo == 2) {
                        System.out.println("Horas trabajadas:");
                        double horas = sc.nextDouble();
                        System.out.println("Tarifa por hora:");
                        double tarifa = sc.nextDouble();
                        empleados.add(new EmpleadoPorHoras(nombre, horas, tarifa));
                    } else if(tipo == 3) {
                        System.out.println("Horas trabajadas:");
                        double horas = sc.nextDouble();
                        System.out.println("Tarifa por proyecto:");
                        double tarifa = sc.nextDouble();
                        empleados.add(new EmpleadoContratista(nombre, horas, tarifa));
                    }
                    break;
                case 2:
                    for(Empleado e : empleados) {
                        System.out.println(e.nombre + " cobra " + e.calcularPago());
                    }
                    break;
            }

        } while(opcion != 3);

        sc.close();
    }
}
