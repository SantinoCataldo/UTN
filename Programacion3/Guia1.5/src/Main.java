import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = DataHelper.cargarProductos();

        // 1. Filtrado y Transformación
        System.out.println("1. Electrónica > 1000 (ordenado desc):");
        List<String> nombresPrecios = productos.stream()
                .filter(p -> p.getCategoria().equals("Electrónica") && p.getPrecio() > 1000)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .map(p -> p.getNombre() + " - $" + p.getPrecio())
                .toList();
        nombresPrecios.forEach(System.out::println);

        // 2. Reducción de Datos
        System.out.println("\n2. Precio promedio 'Hogar' con stock:");
        double promedioHogar = productos.stream()
                .filter(p -> p.getCategoria().equals("Hogar") && p.getStock() > 0)
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("Promedio: " + promedioHogar);

        // 3. Producto mas caro por categoría
        System.out.println("\n3. Producto más caro por categoría:");
        Map<String, Optional<Producto>> masCarosPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Producto::getPrecio))
                ));
        masCarosPorCategoria.forEach((cat, prod) -> System.out.println(cat + ": " + prod.orElse(null)));

        // 4. Uso de Optionals
        System.out.println("\n4. Deportes stock > 10:");
        String nombreDeportes = productos.stream()
                .filter(p -> p.getCategoria().equals("Deportes") && p.getStock() > 10)
                .findFirst()
                .map(p -> p.getNombre().toLowerCase())
                .orElse("Producto Inexistente");
        System.out.println(nombreDeportes);

        // 5. Producto Mas Barato (Precio * stock)
        System.out.println("\n5. Producto más barato (Precio * Stock):");
        try {
            Producto masBarato = productos.stream()
                    .min(Comparator.comparingDouble(p -> p.getPrecio() * p.getStock()))
                    .orElseThrow(() -> new RuntimeException("No hay productos"));
            System.out.println(masBarato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 6. Productos en stock ordenados alfabéticamente (nombre >= 5 chars)
        System.out.println("\n6. Nombres con stock (>= 5 letras, ordenados):");
        List<String> nombresStock = productos.stream()
                .filter(p -> p.getStock() > 0 && p.getNombre().length() >= 5)
                .map(Producto::getNombre)
                .sorted()
                .toList();
        nombresStock.forEach(System.out::println);

        // 7. Calculo de Stock Total (> precio promedio)
        double promedioGral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        int stockTotalSobrePromedio = productos.stream()
                .filter(p -> p.getPrecio() > promedioGral)
                .mapToInt(Producto::getStock)
                .sum();
        System.out.println("\n7. Stock total productos c/ precio > promedio ($" + promedioGral + "): " + stockTotalSobrePromedio);

        // 8. Stock por Categoría (categorías con >= 3 productos)
        System.out.println("\n8. Stock por categoría (mínimo 3 productos):");
        productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria))
                .forEach((cat, lista) -> {
                    if (lista.size() >= 3) {
                        int stockTotal = lista.stream().mapToInt(Producto::getStock).sum();
                        System.out.println(cat + ": " + stockTotal);
                    }
                });

        // 9. Aplicar descuento (15% si stock > 20)
        System.out.println("\n9. Nueva lista con descuento (stock > 20):");
        List<Producto> conDescuento = productos.stream()
                .filter(p -> p.getStock() > 20)
                .map(p -> new Producto(p.getNombre(), p.getPrecio() * 0.85, p.getCategoria(), p.getStock()))
                .toList();
        conDescuento.forEach(System.out::println);

        // 10. Ganancia total inventario
        double gananciaTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock() * (p.getCategoria().equals("Electrónica") ? 0.35 : 0.55))
                .sum();
        System.out.println("\n10. Ganancia total inventario: $" + gananciaTotal);
    }
}
