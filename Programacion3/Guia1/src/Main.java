//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 15, 12);
        List<String> nombres = Arrays.asList("Juan", "Maria", "Pedro", "Ana", "Roberto", "Sol");

        // 1. Filtrar números pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("1. Pares: " + pares);

        // 2. Transformar una lista de nombres a mayúsculas
        List<String> nombresMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("2. Nombres en mayúsculas: " + nombresMayusculas);

        // 3. Ordenar una lista de números
        List<Integer> ordenados = numeros.stream()
                .sorted()
                .toList();
        System.out.println("3. Números ordenados: " + ordenados);

        // 4. Contar elementos mayores a un valor dado (7)
        long mayoresA7 = numeros.stream()
                .filter(n -> n > 7)
                .count();
        System.out.println("4. Cantidad de números mayores a 7: " + mayoresA7);

        // 5. Obtener los primeros 5 elementos de una lista
        List<Integer> primeros5 = numeros.stream()
                .limit(5)
                .toList();
        System.out.println("5. Primeros 5 elementos: " + primeros5);

        // 6. Convertir una lista de palabras en su longitud
        List<Integer> longitudes = nombres.stream()
                .map(String::length)
                .toList();
        System.out.println("6. Longitud de nombres: " + longitudes);

        // 7. Concatenar nombres con una separación
        String nombresConcatenados = nombres.stream()
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("7. Nombres concatenados: " + nombresConcatenados);

        // 8. Eliminar duplicados de una lista
        List<Integer> sinDuplicados = numeros.stream()
                .distinct()
                .toList();
        System.out.println("8. Lista sin duplicados: " + sinDuplicados);

        // 9. Obtener los 3 números más grandes de una lista
        List<Integer> tresMasGrandes = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("9. Los 3 números más grandes: " + tresMasGrandes);

        // 10. Agrupar palabras por su longitud
        Map<Integer, List<String>> agrupadosPorLongitud = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("10. Agrupados por longitud: " + agrupadosPorLongitud);

        // 11. Encontrar el producto de todos los números de una lista
        int producto = numeros.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("11. Producto de todos los números: " + producto);

        // 12. Obtener el nombre más largo de una lista
        String nombreMasLargo = nombres.stream()
                .reduce((n1, n2) -> n1.length() >= n2.length() ? n1 : n2)
                .orElse("");
        System.out.println("12. Nombre más largo: " + nombreMasLargo);

        // 13. Convertir una lista de enteros en una cadena separada por guiones
        String cadenaGuiones = numeros.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println("13. Números separados por guiones: " + cadenaGuiones);

        // 14. Agrupar una lista de números en pares e impares
        Map<Boolean, List<Integer>> particionParesImpares = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("14. Partición pares (true) e impares (false): " + particionParesImpares);

        // 15. Obtener la suma de los cuadrados de los números impares
        int sumaCuadradosImpares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("15. Suma de cuadrados de impares: " + sumaCuadradosImpares);
    }
}