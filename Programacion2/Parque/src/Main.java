import java.util.*;
import static java.util.Scanner.*;

public class Main {
    public static void main(String[] args) {
        List<Atracciones> atracciones = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        atracciones.add(new MontaniaRusa("Dragon Fury", NivelIntensidad.ALTO, Estado.ABIERTA, 6, 860, 120));;
        atracciones.add(new JuegoAgua("Splash River", NivelIntensidad.BAJO, Estado.ABIERTA, 2.5, 80, 10));
        atracciones.add(new AtraccionInfantil("Carrusel", NivelIntensidad.BAJO, Estado.ABIERTA, 8, 20, 3));
        atracciones.add(new MontaniaRusa("Thunder Loop", NivelIntensidad.ALTO, Estado.CERRADA, 3, 800, 100));
        atracciones.add(new JuegoAgua("AquaManía", NivelIntensidad.MEDIO, Estado.CERRADA, 1.8, 100, 8));

        System.out.println("Atracciones de intensidad BAJO:");
        for (Atracciones a : atracciones) {
            if (a.getIntensidad() == NivelIntensidad.BAJO) {
                System.out.println(a.getNombre() + " (" + a.getClass().getSimpleName() + ") - Código: " + a.getCodigo());
            }
        }

        System.out.println("\nIngrese el código de la atracción que desea cambiar a CERRADA:");
        int codigoCambiar = sc.nextInt();
        for (Atracciones a : atracciones) {
            if (a.getCodigo() == codigoCambiar) {
                a.setEstado(Estado.CERRADA);
                System.out.println("Cambiado estado de " + a.getNombre() + " a " + a.getEstado());
            }
        }

        System.out.println("\nMontañas Rusas:");
        for (Atracciones a : atracciones) {
            if (a instanceof MontaniaRusa m) {
                System.out.println(m.getNombre() + " - Tiempo máximo: " + m.obtenerTiempoMaximo() + " min");
            }
        }
    }
}