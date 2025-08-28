import java.util.UUID;
import java.time.LocalDateTime;

public class Cliente {
    private UUID id;
    private String nombre;
    private String email;
    private double descuento;

    public Cliente(UUID id, String nombre, String email, double descuento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void MostrarInfo() {
        System.out.println("Cliente ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Descuento: " + descuento + "%");
    }
}

class Factura {
    private int id;
    private static int idContador = 1;
    private Cliente cliente;
    private LocalDateTime fechaRegistro;
    private double monto;

    public Factura(Cliente cliente, double monto) {
        this.id = idContador++;
        this.cliente = cliente;
        this.fechaRegistro = LocalDateTime.now();
        this.monto = monto - (monto * cliente.getDescuento() / 100);
    }

    public void MostrarInfo() {
        System.out.println("-------------------");
        System.out.println("Factura ID: " + id);
        System.out.println("Fecha de Registro: " + fechaRegistro);
        cliente.MostrarInfo();
        System.out.println("Monto a pagar: $" + monto);
    }
}
