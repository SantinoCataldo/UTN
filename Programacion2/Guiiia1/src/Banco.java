import java.util.Scanner;

public class Banco {
    private static int id;
    private String nombre;
    private int balance;

    Scanner sc = new Scanner(System.in);

    public Banco (String nombre, int balance){
        int contador = 0;
        this.id = contador++;
        this.nombre = nombre;
        this.balance = balance;
    }

    public int credito(){
        System.out.println("Ingrese monto a ingresar: ");
        int montoIngresado = sc.nextInt();
        this.balance = balance + montoIngresado;
        return balance;
    }

    public int debito(){
        System.out.println("Ingrese monto a ingresar: ");
        int montoIngresado = sc.nextInt();
        if(montoIngresado < balance){
            this.balance = balance - montoIngresado;
        } else {
            System.out.println("No hay plata, el bala");
        }
        return balance;
    }
}
