public class Main {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        System.out.println("==================================");
        System.out.println(" PRACTICA DE METODOS NUMERICOS");
        System.out.println("==================================");

        System.out.println("\nSistema de ecuaciones:");
        System.out.println("5x + y + z = 7");
        System.out.println("x + 4y + z = 6");
        System.out.println("x + 2y + 5z = 8");

        System.out.println(
                "\nTolerancia: " + sistema.getTolerancia()
        );

        MetodosIterativos.Resultado jacobi =
                MetodosIterativos.jacobi(sistema);

        MetodosIterativos.Resultado gaussSeidel =
                MetodosIterativos.gaussSeidel(sistema);

        mostrarResultado(jacobi);
        mostrarResultado(gaussSeidel);

        System.out.println("\n===== COMPARACION =====");

        System.out.println(
                "Iteraciones de Jacobi: "
                        + jacobi.getIteraciones()
        );

        System.out.println(
                "Iteraciones de Gauss-Seidel: "
                        + gaussSeidel.getIteraciones()
        );

        System.out.println("\nPrograma finalizado.");
    }

    private static void mostrarResultado(
            MetodosIterativos.Resultado resultado) {

        double[] valores = resultado.getSolucion();

        System.out.println("\n------------------------------");
        System.out.println("Metodo: " + resultado.getMetodo());

        System.out.println(
                "Convergio: "
                        + (resultado.isConvergio() ? "Si" : "No")
        );

        System.out.println(
                "Iteraciones: " + resultado.getIteraciones()
        );

        System.out.printf("x = %.8f%n", valores[0]);
        System.out.printf("y = %.8f%n", valores[1]);
        System.out.printf("z = %.8f%n", valores[2]);

        System.out.printf(
                "Error final: %.10f%n",
                resultado.getErrorFinal()
        );
    }
}