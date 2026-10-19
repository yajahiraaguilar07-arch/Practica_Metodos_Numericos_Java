public class MetodosIterativos {

    public static class Resultado {
        private final String metodo;
        private final double[] solucion;
        private final int iteraciones;
        private final double errorFinal;
        private final boolean convergio;

        public Resultado(String metodo, double[] solucion,
                         int iteraciones, double errorFinal,
                         boolean convergio) {
            this.metodo = metodo;
            this.solucion = solucion.clone();
            this.iteraciones = iteraciones;
            this.errorFinal = errorFinal;
            this.convergio = convergio;
        }

        public String getMetodo() {
            return metodo;
        }

        public double[] getSolucion() {
            return solucion.clone();
        }

        public int getIteraciones() {
            return iteraciones;
        }

        public double getErrorFinal() {
            return errorFinal;
        }

        public boolean isConvergio() {
            return convergio;
        }
    }

    // Metodo de Jacobi
    public static Resultado jacobi(Sistema sistema) {
        double[][] A = sistema.getA();
        double[] b = sistema.getB();
        double[] x = sistema.getInicial();
        double tolerancia = sistema.getTolerancia();

        double error = Double.POSITIVE_INFINITY;

        for (int iter = 1;
             iter <= sistema.getMaxIteraciones(); iter++) {

            double[] nuevo = new double[x.length];

            for (int i = 0; i < A.length; i++) {
                double suma = 0;

                for (int j = 0; j < A.length; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }

                nuevo[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(nuevo, x);
            x = nuevo;

            if (error < tolerancia) {
                return new Resultado(
                        "Jacobi", x, iter, error, true
                );
            }
        }

        return new Resultado(
                "Jacobi", x, sistema.getMaxIteraciones(),
                error, false
        );
    }

    // Metodo de Gauss-Seidel
    public static Resultado gaussSeidel(Sistema sistema) {
        double[][] A = sistema.getA();
        double[] b = sistema.getB();
        double[] x = sistema.getInicial();
        double tolerancia = sistema.getTolerancia();

        double error = Double.POSITIVE_INFINITY;

        for (int iter = 1;
             iter <= sistema.getMaxIteraciones(); iter++) {

            double[] anterior = x.clone();

            for (int i = 0; i < A.length; i++) {
                double suma = 0;

                for (int j = 0; j < A.length; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }

                x[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(x, anterior);

            if (error < tolerancia) {
                return new Resultado(
                        "Gauss-Seidel", x, iter, error, true
                );
            }
        }

        return new Resultado(
                "Gauss-Seidel", x, sistema.getMaxIteraciones(),
                error, false
        );
    }

    // Calcula el maximo cambio entre iteraciones
    private static double calcularError(
            double[] nuevo, double[] anterior) {

        double maximo = 0;

        for (int i = 0; i < nuevo.length; i++) {
            maximo = Math.max(
                    maximo,
                    Math.abs(nuevo[i] - anterior[i])
            );
        }

        return maximo;
    }
}