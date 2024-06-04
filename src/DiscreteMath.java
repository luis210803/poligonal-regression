public class DiscreteMath {
    // Método para calcular la regresión polinómica
    public static double[][] calculatePolynomialRegression(double[][] data) {
        // Calcular las sumas necesarias para la regresión
        int n = data.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0, sumX2Y = 0;

        // Calcular las sumas necesarias
        for (double[] datum : data) {
            double x = datum[0];
            double y = datum[1];
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumX3 += Math.pow(x, 3);
            sumX4 += Math.pow(x, 4);
            sumX2Y += Math.pow(x, 2) * y;
        }

        // Resolver el sistema de ecuaciones para obtener los coeficientes
        double[][] coefficients = new double[3][1];
        coefficients[0][0] = (sumY * sumX2 - sumX * sumXY) / (n * sumX4 - sumX2 * sumX2);
        coefficients[1][0] = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        coefficients[2][0] = (sumX2Y * n - sumX2 * sumY) / (sumX3 * n - sumX2 * sumX);

        return coefficients;
    }
    // Método para calcular el error de la regresión polinómica
    public static double calculateError(double[][] data, double[][] coefficients) {
        double error = 0;
        for (double[] datum : data) {
            double x = datum[0];
            double y = datum[1];
            double predictedY = coefficients[0][0] + coefficients[1][0] * x + coefficients[2][0] * x * x;
            error += Math.pow(y - predictedY, 2);
        }
        return error;
    }
}
