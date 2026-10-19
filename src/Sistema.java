public class Sistema {

    private final double[][] A = {
            {5, 1, 1},
            {1, 4, 1},
            {1, 2, 5}
    };

    private final double[] b = {7, 6, 8};
    private final double[] inicial = {0, 0, 0};

    private final double tolerancia = 0.0001;
    private final int maxIteraciones = 10000;

    public double[][] getA() {
        double[][] copia = new double[A.length][];
        for (int i = 0; i < A.length; i++) {
            copia[i] = A[i].clone();
        }
        return copia;
    }

    public double[] getB() {
        return b.clone();
    }

    public double[] getInicial() {
        return inicial.clone();
    }

    public double getTolerancia() {
        return tolerancia;
    }

    public int getMaxIteraciones() {
        return maxIteraciones;
    }
}
