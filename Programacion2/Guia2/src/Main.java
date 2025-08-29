import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        /* Punto 1
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
                        empleados.add( new EmpleadoTiempoCompleto(nombre, salario));
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
                        System.out.println(e.getNombre() + " cobra " + e.calcularPago());
                    }
                    break;
            }

        } while(opcion != 3);

        sc.close();
        */

        /* Punto 2
        Autor autor = new Autor("Joshua", "Bloch", "joshua@email.com", 'M');

        System.out.println(autor);

        Libro libro = new Libro("Effective Java", autor, 450, 150);

        System.out.println(libro);

        libro.setPrecio(500);
        libro.aumentarStock(50);

        Autor autorDelLibro = libro.getAutor();
        System.out.println("Nombre: " + autorDelLibro.getNombre());
        System.out.println("Apellido: " + autorDelLibro.getApellido());
        System.out.println("Email: " + autorDelLibro.getEmail());
        System.out.println("Género: " + autorDelLibro.getGenero());

        libro.imprimirMensajeVenta();
         */

        /*Punto 3
        Cliente cliente = new Cliente(UUID.randomUUID(), "Jorge", "Jorge@gmail.com", 10);
        cliente.MostrarInfo();
        Factura factura = new Factura(cliente, 1000);
        factura.MostrarInfo();
         */

        /* Punto 4
        Cilindro cilindro1 = new Cilindro();

        cilindro1.mostrarDatos();

        Cilindro cilindro2 = new Cilindro(1, 2, "azul");

        cilindro2.mostrarDatos();
         */

        /* Punto 5
        Estudiante e1 = new Estudiante("Ana", "García", "ana@gmail.com", "Calle 1", 12345678, 10000, 2022, "Ingeniería");
        Estudiante e2 = new Estudiante("Luis", "Pérez", "luis@gmail.com", "Calle 2", 23456789, 12000, 2021, "Medicina");
        Estudiante e3 = new Estudiante("Sofía", "López", "sofia@gmail.com", "Calle 3", 34567890, 11000, 2023, "Derecho");
        Estudiante e4 = new Estudiante("Juan", "Martínez", "juan@gmail.com", "Calle 4", 45678901, 9000, 2020, "Arquitectura");

        Staff s1 = new Staff("Carlos", "Ruiz", "carlos@gmail.com", "Calle 5", 56789012, "Mañana", 20000);
        Staff s2 = new Staff("María", "Fernández", "maria@gmail.com", "Calle 6", 67890123, "Tarde", 22000);
        Staff s3 = new Staff("Pedro", "Sosa", "pedro@gmail.com", "Calle 7", 78901234, "Noche", 21000);
        Staff s4 = new Staff("Lucía", "Díaz", "lucia@gmail.com", "Calle 8", 89012345, "Mañana", 23000);

        Persona[] personas = {e1, e2, e3, e4, s1, s2, s3, s4};

        int cantidadEstudiantes = 0;
        int cantidadStaff = 0;
        int totalCuotas = 0;

        for (Persona p : personas) {
            if (p instanceof Estudiante) {
                cantidadEstudiantes++;
                totalCuotas += ((Estudiante)p).getCuotaMensual();
            } else if (p instanceof Staff) {
                cantidadStaff++;
            }
        }

        System.out.println("Cantidad de estudiantes: " + cantidadEstudiantes);
        System.out.println("Cantidad de staff: " + cantidadStaff);
        System.out.println("Total de ingresos por cuotas: $" + totalCuotas);
         */
    }

}