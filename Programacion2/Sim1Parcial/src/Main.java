import java.util.Scanner;

public class Main {
    private static Empresa empresa = new Empresa();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatosEjemplo();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    quitarVehiculo();
                    break;
                case 3:
                    listarVehiculos();
                    break;
                case 4:
                    realizarMantenimiento();
                    break;
                case 5:
                    verInformacionVehiculo();
                    break;
                case 6:
                    agregarChofer();
                    break;
                case 7:
                    quitarChofer();
                    break;
                case 8:
                    listarChoferes();
                    break;
                case 9:
                    verInformacionChofer();
                    break;
                case 10:
                    agregarViaje();
                    break;
                case 11:
                    listarViajes();
                    break;
                case 12:
                    verInformacionViaje();
                    break;
                case 13:
                    calcularTiempoEstimado();
                    break;
                case 14:
                    calcularPagoChofer();
                    break;
                case 15:
                    verRecaudacionTotal();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema de gestión de transportes!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE TRANSPORTES ===");
        System.out.println("1.  Agregar vehículo");
        System.out.println("2.  Quitar vehículo");
        System.out.println("3.  Listar vehículos");
        System.out.println("4.  Realizar mantenimiento a vehículo");
        System.out.println("5.  Ver información de vehículo");
        System.out.println("6.  Agregar chofer");
        System.out.println("7.  Quitar chofer");
        System.out.println("8.  Listar choferes");
        System.out.println("9.  Ver información de chofer");
        System.out.println("10. Agregar viaje");
        System.out.println("11. Listar viajes");
        System.out.println("12. Ver información de viaje");
        System.out.println("13. Calcular tiempo estimado de viaje");
        System.out.println("14. Calcular pago a chofer por viaje");
        System.out.println("15. Ver recaudación total");
        System.out.println("0.  Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarVehiculo() {
        System.out.println("\n=== AGREGAR VEHÍCULO ===");
        System.out.println("Tipos de vehículo:");
        System.out.println("1. Transporte de Pasajeros");
        System.out.println("2. Transporte de Carga");
        System.out.println("3. Transporte Empresarial");
        System.out.print("Seleccione el tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la patente: ");
        String patente = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();

        System.out.println("Marcas disponibles: FORD, CHEVROLET, DODGE, JEEP");
        System.out.print("Ingrese la marca: ");
        String marcaStr = scanner.nextLine().toUpperCase();
        Marcas marca = Marcas.valueOf(marcaStr);

        System.out.print("Ingrese la velocidad recomendada (km/h): ");
        double velocidad = scanner.nextDouble();
        System.out.print("Ingrese el kilometraje: ");
        double kilometraje = scanner.nextDouble();

        Vehiculo vehiculo = null;

        switch (tipo) {
            case 1: // TransPasajero
                System.out.print("Ingrese número de pasajeros: ");
                int numPasajeros = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Categorías disponibles: STANDARD, PREMIUM, DELUXE");
                System.out.print("Ingrese la categoría: ");
                String categoriaStr = scanner.nextLine().toUpperCase();
                Categoria categoria = Categoria.valueOf(categoriaStr);
                vehiculo = new TransPasajero(numPasajeros, categoria, modelo, marca, patente, velocidad, kilometraje);
                break;

            case 2: // TransCarga
                System.out.print("Ingrese peso máximo: ");
                double pesoMax = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Medidas disponibles: KGS, LTS, LBS");
                System.out.print("Ingrese la medida: ");
                String medidaStr = scanner.nextLine().toUpperCase();
                Medida medida = Medida.valueOf(medidaStr);
                vehiculo = new TransCarga(pesoMax, medida, modelo, marca, patente, velocidad, kilometraje);
                break;

            case 3: // TransEmpresariales
                System.out.print("Ingrese cantidad de butacas: ");
                int cantButacas = scanner.nextInt();
                System.out.print("Ingrese año de adquisición: ");
                int anio = scanner.nextInt();
                vehiculo = new TransEmpresariales(cantButacas, anio, modelo, marca, patente, velocidad, kilometraje);
                break;
        }

        if (vehiculo != null) {
            empresa.agregarVehiculo(vehiculo);
            System.out.println("Vehículo agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el vehículo.");
        }
    }

    private static void quitarVehiculo() {
        System.out.println("\n=== QUITAR VEHÍCULO ===");
        System.out.print("Ingrese la patente del vehículo a quitar: ");
        String patente = scanner.nextLine();

        if (empresa.quitarVehiculo(patente)) {
            System.out.println("Vehículo quitado exitosamente.");
        } else {
            System.out.println("No se encontró el vehículo con esa patente.");
        }
    }

    private static void listarVehiculos() {
        System.out.println("\n=== LISTA DE VEHÍCULOS ===");
        if (empresa.getVehiculos().isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo vehiculo : empresa.getVehiculos()) {
            System.out.println("Patente: " + vehiculo.getPatente() +
                             " - Modelo: " + vehiculo.getModelo() +
                             " - Marca: " + vehiculo.getMarca());
        }
    }

    private static void realizarMantenimiento() {
        System.out.println("\n=== REALIZAR MANTENIMIENTO ===");
        System.out.print("Ingrese la patente del vehículo: ");
        String patente = scanner.nextLine();
        System.out.print("Ingrese nueva velocidad recomendada: ");
        double velocidad = scanner.nextDouble();
        System.out.print("Ingrese nuevo kilometraje: ");
        double kilometraje = scanner.nextDouble();
        System.out.print("Ingrese nuevo valor (pasajeros/carga): ");
        int valor = scanner.nextInt();

        if (empresa.realizarMantenimiento(patente, velocidad, kilometraje, valor)) {
            System.out.println("Mantenimiento realizado exitosamente.");
        } else {
            System.out.println("No se pudo realizar el mantenimiento. Verifique la patente o si el vehículo admite mantenimiento.");
        }
    }

    private static void verInformacionVehiculo() {
        System.out.println("\n=== INFORMACIÓN DEL VEHÍCULO ===");
        System.out.print("Ingrese la patente del vehículo: ");
        String patente = scanner.nextLine();
        System.out.println(empresa.obtenerInformacionVehiculo(patente));
    }

    private static void agregarChofer() {
        System.out.println("\n=== AGREGAR CHOFER ===");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el DNI: ");
        int dni = scanner.nextInt();
        System.out.print("Ingrese el salario por KM: ");
        float salario = scanner.nextFloat();

        Chofer chofer = new Chofer(nombre, apellido, dni, salario);
        empresa.agregarChofer(chofer);
        System.out.println("Chofer agregado exitosamente.");
    }

    private static void quitarChofer() {
        System.out.println("\n=== QUITAR CHOFER ===");
        System.out.print("Ingrese el DNI del chofer a quitar: ");
        int dni = scanner.nextInt();

        if (empresa.quitarChofer(dni)) {
            System.out.println("Chofer quitado exitosamente.");
        } else {
            System.out.println("No se encontró el chofer con ese DNI.");
        }
    }

    private static void listarChoferes() {
        System.out.println("\n=== LISTA DE CHOFERES ===");
        if (empresa.getChoferes().isEmpty()) {
            System.out.println("No hay choferes registrados.");
            return;
        }

        for (Chofer chofer : empresa.getChoferes()) {
            System.out.println("DNI: " + chofer.getDni() +
                             " - Nombre: " + chofer.getNombre() + " " + chofer.getApellido() +
                             " - Salario/KM: $" + chofer.getSalarioKM());
        }
    }

    private static void verInformacionChofer() {
        System.out.println("\n=== INFORMACIÓN DEL CHOFER ===");
        System.out.print("Ingrese el DNI del chofer: ");
        int dni = scanner.nextInt();
        System.out.println(empresa.obtenerInformacionChofer(dni));
    }

    private static void agregarViaje() {
        System.out.println("\n=== AGREGAR VIAJE ===");

        // Mostrar vehículos disponibles
        System.out.println("Vehículos disponibles:");
        listarVehiculos();
        System.out.print("Ingrese la patente del vehículo: ");
        String patente = scanner.nextLine();
        Vehiculo vehiculo = empresa.buscarVehiculoPorPatente(patente);

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        // Mostrar choferes disponibles
        System.out.println("Choferes disponibles:");
        listarChoferes();
        System.out.print("Ingrese el DNI del chofer: ");
        int dni = scanner.nextInt();
        scanner.nextLine();
        Chofer chofer = empresa.buscarChoferPorDni(dni);

        if (chofer == null) {
            System.out.println("Chofer no encontrado.");
            return;
        }

        System.out.print("Ingrese el destino: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese la distancia en km: ");
        double distancia = scanner.nextDouble();
        System.out.print("Ingrese la tarifa: ");
        double tarifa = scanner.nextDouble();
        System.out.print("Ingrese cantidad de pasajeros/carga: ");
        int cantidad = scanner.nextInt();

        Viaje viaje = new Viaje(vehiculo, chofer, cantidad, destino, distancia, tarifa);
        empresa.registrarViaje(viaje);
        System.out.println("Viaje registrado exitosamente con ID: " + viaje.getId());
    }

    private static void listarViajes() {
        System.out.println("\n=== LISTA DE VIAJES ===");
        if (empresa.getViajes().isEmpty()) {
            System.out.println("No hay viajes registrados.");
            return;
        }

        for (Viaje viaje : empresa.getViajes()) {
            System.out.println("ID: " + viaje.getId() +
                             " - Destino: " + viaje.getDestino() +
                             " - Distancia: " + viaje.getDistanciaKms() + " km" +
                             " - Tarifa: $" + viaje.getTarifa());
        }
    }

    private static void verInformacionViaje() {
        System.out.println("\n=== INFORMACIÓN DEL VIAJE ===");
        System.out.print("Ingrese el ID del viaje: ");
        int id = scanner.nextInt();
        System.out.println(empresa.obtenerInformacionViaje(id));
    }

    private static void calcularTiempoEstimado() {
        System.out.println("\n=== CALCULAR TIEMPO ESTIMADO ===");
        System.out.print("Ingrese el ID del viaje: ");
        int id = scanner.nextInt();
        double tiempo = empresa.calcularTiempoEstimado(id);

        if (tiempo >= 0) {
            System.out.printf("Tiempo estimado del viaje: %.2f horas\n", tiempo);
        } else {
            System.out.println("Viaje no encontrado.");
        }
    }

    private static void calcularPagoChofer() {
        System.out.println("\n=== CALCULAR PAGO AL CHOFER ===");
        System.out.print("Ingrese el ID del viaje: ");
        int id = scanner.nextInt();
        double pago = empresa.calcularPagoChofer(id);

        if (pago >= 0) {
            System.out.printf("Pago al chofer por el viaje: $%.2f\n", pago);
        } else {
            System.out.println("Viaje no encontrado.");
        }
    }

    private static void verRecaudacionTotal() {
        System.out.println("\n=== RECAUDACIÓN TOTAL ===");
        double total = empresa.calcularRecaudacionTotal();
        System.out.printf("Recaudación total de todos los viajes: $%.2f\n", total);
    }

    private static void inicializarDatosEjemplo() {
        empresa.agregarChofer(new Chofer("Juan", "Pérez", 12345678, 150.0f));
        empresa.agregarChofer(new Chofer("María", "González", 87654321, 180.0f));

        empresa.agregarVehiculo(new TransPasajero(40, Categoria.STANDARD, "Sprinter", Marcas.FORD, "ABC123", 80.0, 50000.0));
        empresa.agregarVehiculo(new TransCarga(5000.0, Medida.KGS, "F-350", Marcas.FORD, "DEF456", 70.0, 80000.0));
        empresa.agregarVehiculo(new TransEmpresariales(20, 2020, "Transit", Marcas.FORD, "GHI789", 90.0, 30000.0));

        System.out.println("Datos de ejemplo cargados exitosamente.");
    }
}