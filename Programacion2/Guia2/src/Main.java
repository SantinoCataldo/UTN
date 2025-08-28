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

        /*
        Cliente cliente = new Cliente(UUID.randomUUID(), "Jorge", "Jorge@gmail.com", 10);
        cliente.MostrarInfo();
        Factura factura = new Factura(cliente, 1000);
        factura.MostrarInfo();
         */

        Cilindro cilindro1 = new Cilindro();

        System.out.println("Radio: " + cilindro1.getRadio());
        System.out.println("Altura: " + cilindro1.getAltura());
        System.out.println("Área de la base: " + cilindro1.getArea());
        System.out.println("Volumen: " + cilindro1.getVolumen());

        Cilindro cilindro2 = new Cilindro(12, 15, "azul");

        System.out.println("Radio: " + cilindro2.getRadio());
        System.out.println("Altura: " + cilindro2.getAltura());
        System.out.println("Área de la base: " + cilindro2.getArea());
        System.out.println("Volumen: " + cilindro2.getVolumen());
    }
}