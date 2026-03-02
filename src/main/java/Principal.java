import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;

        String menu = """
                ***************************************************
                Bienvenido al Conversor de Moneda de Alura
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ***************************************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            try {
                opcion = lectura.nextInt();
                String monedaBase = "";
                String monedaDestino = "";

                switch (opcion) {
                    case 1 -> { monedaBase = "USD"; monedaDestino = "ARS"; }
                    case 2 -> { monedaBase = "ARS"; monedaDestino = "USD"; }
                    case 3 -> { monedaBase = "USD"; monedaDestino = "BRL"; }
                    case 4 -> { monedaBase = "BRL"; monedaDestino = "USD"; }
                    case 5 -> { monedaBase = "USD"; monedaDestino = "COP"; }
                    case 6 -> { monedaBase = "COP"; monedaDestino = "USD"; }
                    case 7 -> {
                        System.out.println("Gracias por usar mi conversor");
                        continue;
                    }
                    default -> {
                        System.out.println("Opción no válida. Intente de nuevo.");
                        continue;
                    }
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double cantidad = lectura.nextDouble();

                Moneda datos = consulta.buscarMoneda(monedaBase);
                Double tasaDeCambio = datos.conversion_rates().get(monedaDestino);
                double resultado = cantidad * tasaDeCambio;

                System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n%n",
                        cantidad, monedaBase, resultado, monedaDestino);

            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese solo números.");
                lectura.nextLine(); // Limpiamos el error para que no se trabe el bucle
            }
        }
    }
}